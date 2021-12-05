package com.carvajal.ebusiness.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.carvajal.ebusiness.dao.WishListDAO;
import com.carvajal.ebusiness.dto.ClientDTO;
//import com.carvajal.ebusiness.dto.ProductDTO;
import com.carvajal.ebusiness.dto.WishListDTO;
import com.carvajal.ebusiness.model.Client;
import com.carvajal.ebusiness.model.Operations;
import com.carvajal.ebusiness.model.States;
import com.carvajal.ebusiness.model.WishList;
import com.carvajal.ebusiness.model.WishListHis;
import com.carvajal.ebusiness.security.Security;
import com.carvajal.ebusiness.service.WishListHisService;
import com.carvajal.ebusiness.service.WishListService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListServiceImpl implements WishListService{

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WishListDAO wishListDAO;

    @Autowired
    private WishListHisService wlhService;

    @Autowired
    private ProductServiceImpl pService;

    @Autowired
    private Security security;

    @Override
    public List<WishListDTO> loadClientWishList(ClientDTO client) {

        logger.info("clientId: "+client.toString());

        List<WishListDTO> wlDTO = new ArrayList<>();

        Client cliAux = new Client(client.getDocument(), client.getName(), client.getUsername(),security.passwordEncoder().encode(client.getPassword()),null);

        List<WishList> wishlist = wishListDAO.findByClient(cliAux);
        wishlist.forEach(wl ->{
            
            WishListDTO aux = new WishListDTO(
                wl.getId(), 
                wl.getCreateDate(), 
                wl.getUpdateDate(), 
                wl.getQuantity(), 
                wl.getClient(), 
                wl.getProduct(),
                wl.getState()
                );
            wlDTO.add(aux);
        });
        return wlDTO;
    }

    @Override
    public boolean deleteProductFromWishList(long id) {
        Optional<WishList> wl = wishListDAO.findById(id);

        if (wl.isPresent()) {
            wl.get().setState(States.D.name());
            wishListDAO.save(wl.get());
            //wishListDAO.deleteById(id);

            /*ADDING HISTORIC */
            wlhService.addWishListHis(new WishListHis(
                wl.get().getId(), 
                wl.get(), 
                Operations.DELETE.name()
            ));
            
            return true;

        } else {
            return false;
        }

    }

    @Override
    public Optional<WishListDTO> addProductToWishList(WishListDTO parameters) {
        Optional<WishList> aux = wishListDAO.findById(parameters.getId());
        if(aux.isPresent()){
            return Optional.empty();
        }
        else{
            parameters.setCreateDate(LocalDateTime.now());
            parameters.setUpdateDate(LocalDateTime.now());
            WishList wl = new WishList(
                parameters.getId(), 
                parameters.getCreateDate(), 
                parameters.getUpdateDate(),
                parameters.getQuantity(), 
                parameters.getClient(), 
                parameters.getProduct(),
                States.V.name()
            );
            WishList newProduct = wishListDAO.save(wl);

            /*ADDING HISTORIC */
            wlhService.addWishListHis(new WishListHis(
                newProduct.getId(), 
                newProduct, 
                Operations.INSERT.name()
            ));

            WishListDTO productDTO = new WishListDTO();
            productDTO.setId(newProduct.getId());
            productDTO.setProduct(newProduct.getProduct());
            productDTO.setCreateDate(newProduct.getCreateDate());
            productDTO.setUpdateDate(newProduct.getUpdateDate());
            productDTO.setQuantity(newProduct.getQuantity());
            productDTO.setClient(newProduct.getClient());

            return Optional.of(productDTO);
        }
        
    }

    @Override
    public Optional<WishListDTO> updateProductInWishList(WishListDTO parameters) {
        Optional<WishList> aux = wishListDAO.findById(parameters.getId());
        if(!aux.isPresent()){
            return Optional.empty();
        }
        else{
            parameters.setUpdateDate(LocalDateTime.now());
            WishList newProduct = wishListDAO.save(new WishList(
                parameters.getId(), 
                parameters.getCreateDate(), 
                parameters.getUpdateDate(), 
                parameters.getQuantity(), 
                parameters.getClient(), 
                parameters.getProduct(),
                States.V.name()
            ));

            /*ADDING HISTORIC */
            wlhService.addWishListHis(new WishListHis(
                newProduct.getId(), 
                newProduct, 
                Operations.UPDATE.name()
            ));
            
            WishListDTO productDTO = new WishListDTO();
            productDTO.setId(newProduct.getId());
            productDTO.setProduct(newProduct.getProduct());
            productDTO.setCreateDate(newProduct.getCreateDate());
            productDTO.setUpdateDate(newProduct.getUpdateDate());
            productDTO.setQuantity(newProduct.getQuantity());
            productDTO.setClient(newProduct.getClient());

            return Optional.of(productDTO);
        }
    }

    @Override
    public List<WishListDTO> productsWithoutStock(ClientDTO parameters) {
        List<WishListDTO> prWithoutStock = new ArrayList<>();
        
        ClientDTO client = new ClientDTO(
            parameters.getDocument(), 
            parameters.getName(), 
            parameters.getUsername(),
            parameters.getPassword()
        );
        List<WishListDTO> wlClient = loadClientWishList(client);

        if (wlClient.isEmpty()) {
            return null;
        } else {
            wlClient.forEach(cli ->{

                if (!pService.productHasStock(cli.getProduct().getId(), cli.getQuantity())
                    && !cli.getState().equals(States.D.name())) {
                    prWithoutStock.add(cli);
                }
            });
        }

        return prWithoutStock;
    }
    
}
