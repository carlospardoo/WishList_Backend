package com.carvajal.ebusiness.service;

import java.util.List;
import java.util.Optional;

import com.carvajal.ebusiness.dto.ClientDTO;
import com.carvajal.ebusiness.dto.WishListDTO;
//import com.carvajal.ebusiness.model.Client;
//import com.carvajal.ebusiness.model.Product;
import com.carvajal.ebusiness.model.WishList;

public interface WishListService {

    public List<WishListDTO> loadClientWishList(ClientDTO client);

    public boolean deleteProductFromWishList(long id);

    public Optional<WishListDTO> addProductToWishList(WishList parameters);

    public Optional<WishListDTO> updateProductInWishList(WishList parameters);

}
