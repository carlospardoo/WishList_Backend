package com.carvajal.ebusiness.mapper;

import java.util.Optional;

import com.carvajal.ebusiness.dto.RolDTO;
import com.carvajal.ebusiness.model.Rol;

public class RolMapper {

    public static Rol rolDtoToRol(Optional<RolDTO> rolDTO) {

        Rol rol = new Rol();

        if (rolDTO.isPresent()) {
            rol.setId(rolDTO.get().getId());
            rol.setName(rolDTO.get().getName());
        }

        return rol;
    }

    public static Rol rolDtoToRol(RolDTO rolDTO) {
        Rol rol = new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());
        return rol;
    }

    public static RolDTO rolToRolDto(Rol rol) {
        RolDTO rolDTO = new RolDTO(rol.getId(), rol.getName());
        return rolDTO;
    }

}
