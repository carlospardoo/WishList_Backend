package com.carvajal.ebusiness.dao;

import java.util.List;
import java.util.Optional;

// import com.carvajal.ebusiness.dto.ClientDTO;
import com.carvajal.ebusiness.model.Client;
import com.carvajal.ebusiness.model.WishList;

import org.springframework.data.repository.CrudRepository;

public interface WishListDAO extends CrudRepository<WishList,Long>{
    
    public List<WishList> findByClient(Client client);

    public Optional<WishList> findById(Long id);

}
