package com.carvajal.ebusiness.service;

import java.util.Optional;

import com.carvajal.ebusiness.dto.RolDTO;
import com.carvajal.ebusiness.model.Rol;

public interface RolService {

    public Optional<Rol> loadRol(String name);

    public Optional<RolDTO> addRol(String name);
}
