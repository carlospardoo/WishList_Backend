package com.carvajal.ebusiness.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.carvajal.ebusiness.dao.ProductDAO;
import com.carvajal.ebusiness.dto.ProductDTO;
import com.carvajal.ebusiness.model.Product;
import com.carvajal.ebusiness.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired ProductDAO productDAO;

    public ProductServiceImpl() {

    }

    @Override
    public List<ProductDTO> getAllProducts() {

        List<Product> productList = productDAO.findAll();
        List<ProductDTO> productDTO = new ArrayList<>();
        productList.forEach(prod->{
            productDTO.add(new ProductDTO(
                prod.getId(), 
                prod.getName(), 
                prod.getPrice(), 
                prod.getStock()
                ));
        });

        return productDTO;
    }

    @Override
    public Optional<Product> getProduct(int proId) {
        Optional<Product> product = productDAO.findById(proId);

        if (product.isPresent()) {
            return product;
        }

        return Optional.empty();
    }


    @Override
    public boolean productHasStock(int proId, int quantity) {
        Optional<Product> product = getProduct(proId);
        if (product.isPresent()) {
            if (quantity > product.get().getStock()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Product> saveProducts(List<Product> products) {
        
        List<Product> data2 = new ArrayList<>();
        
        Iterable<Product> prodIter = productDAO.saveAll(products);

        prodIter.forEach(pro->{
            data2.add(pro);
        });

        return data2;
    }

    public List<Product> productsDefault(){
        List<Product> data = new ArrayList<>();

        Product prod = new Product();
        prod.setName("teclado");
        prod.setPrice(3500);
        prod.setStock(25);

        Product prod2 = new Product();
        prod2.setName("mouse");
        prod2.setPrice(40000);
        prod2.setStock(16);

        data.add(prod);
        data.add(prod2);

        return data;
    }
    
}
