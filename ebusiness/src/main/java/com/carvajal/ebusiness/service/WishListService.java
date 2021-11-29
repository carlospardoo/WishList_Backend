package com.carvajal.ebusiness.service;

import java.util.List;
import java.util.Optional;

import com.carvajal.ebusiness.dto.ClientDTO;
import com.carvajal.ebusiness.dto.WishListDTO;

public interface WishListService {

    public List<WishListDTO> loadClientWishList(ClientDTO client);

    public boolean deleteProductFromWishList(long id);

    public Optional<WishListDTO> addProductToWishList(WishListDTO parameters);

    public Optional<WishListDTO> updateProductInWishList(WishListDTO parameters);

    public List<WishListDTO> productsWithoutStock(ClientDTO parameters);

}
