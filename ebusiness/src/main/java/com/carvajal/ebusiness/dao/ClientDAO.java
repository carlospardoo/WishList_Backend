package com.carvajal.ebusiness.dao;

import java.util.Optional;

import com.carvajal.ebusiness.model.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client,Long> {

    public Optional<Client> findByUsername(String username);

}
