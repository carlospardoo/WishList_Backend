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
import com.carvajal.ebusiness.model.WishList;
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

    @Override
    public List<WishListDTO> loadClientWishList(ClientDTO client) {

        logger.info("clientId: "+client.toString());

        List<WishListDTO> wlDTO = new ArrayList<>();

        Client cliAux = new Client(client.getDocument(), client.getName(), client.getUsername());

        List<WishList> wishlist = wishListDAO.findByClient(cliAux);
        wishlist.forEach(wl ->{
            
            WishListDTO aux = new WishListDTO(
                wl.getId(), 
                wl.getCreateDate(), 
                wl.getUpdateDate(), 
                wl.getQuantity(), 
                wl.getClient(), 
                wl.getProduct()
                );
            wlDTO.add(aux);
        });
        return wlDTO;
    }

    @Override
    public boolean deleteProductFromWishList(long id) {
        try {
            wishListDAO.deleteById(id);
        } catch (Exception e) {
            return false;
        }
        
        return true;
    }

    @Override
    public Optional<WishListDTO> addProductToWishList(WishList parameters) {
        Optional<WishList> aux = wishListDAO.findById(parameters.getId());
        if(aux.isPresent()){
            return Optional.empty();
        }
        else{
            parameters.setCreateDate(LocalDateTime.now());
            parameters.setUpdateDate(LocalDateTime.now());
            WishList newProduct = wishListDAO.save(parameters);
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
    public Optional<WishListDTO> updateProductInWishList(WishList parameters) {
        Optional<WishList> aux = wishListDAO.findById(parameters.getId());
        if(!aux.isPresent()){
            return Optional.empty();
        }
        else{
            parameters.setUpdateDate(LocalDateTime.now());
            WishList newProduct = wishListDAO.save(parameters);
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
    
}
