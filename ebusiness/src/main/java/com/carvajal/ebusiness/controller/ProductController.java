package com.carvajal.ebusiness.controller;

import java.util.List;

import com.carvajal.ebusiness.dto.ProductDTO;
import com.carvajal.ebusiness.service.impl.ProductServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping(value = "/load-products")
    @ResponseStatus(value = HttpStatus.ACCEPTED )
    public List<ProductDTO> sendFullProducts(){
        productService.saveProducts(productService.productsDefault());

        List<ProductDTO> products = productService.getAllProducts();
        if (products.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return products;
        }
    }
}
