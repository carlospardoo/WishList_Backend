package com.carvajal.ebusiness.dao;

import com.carvajal.ebusiness.model.Rol;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolDAO extends CrudRepository<Rol,Integer>{
    
}
