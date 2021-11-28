package com.carvajal.ebusiness.service;

import java.util.List;
import java.util.Optional;

import com.carvajal.ebusiness.dto.ProductDTO;
import com.carvajal.ebusiness.model.Product;

public interface ProductService {

    public List<ProductDTO> getAllProducts();

    public Optional<Product> getProduct(int proId);

    public boolean productHasStock(int proId);

    public List<Product> saveProducts(List<Product> products);
    
}
