package com.carvajal.ebusiness.dao;

import com.carvajal.ebusiness.model.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client,Long> {
    
}
