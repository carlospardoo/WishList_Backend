package com.carvajal.ebusiness.dao;

import java.util.List;
import java.util.Optional;

import com.carvajal.ebusiness.model.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends CrudRepository <Product, Integer>{
    @Override
    public List<Product> findAll();

    @Override
    public Optional<Product> findById(Integer id);
    
}
