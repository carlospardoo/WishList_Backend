package com.carvajal.ebusiness.service.impl;

import java.util.Optional;

import com.carvajal.ebusiness.dao.RolDAO;
import com.carvajal.ebusiness.dto.RolDTO;
import com.carvajal.ebusiness.model.Rol;
import com.carvajal.ebusiness.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rolServiceImpl")
public class RolServiceImpl implements RolService{

    @Autowired
    private RolDAO rolDAO;

    @Override
    public Optional<Rol> loadRol(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<RolDTO> addRol(String name) {
        Rol rol = new Rol();
        rol.setName(name);
        Rol rolNew = rolDAO.save(rol);

        if(Optional.of(rolNew).isPresent()){
            RolDTO rolDTO = new RolDTO(rolNew.getId(), rolNew.getName());
            return Optional.of(rolDTO);
        }
        else{
            return Optional.empty();
        }
    }
    
}
