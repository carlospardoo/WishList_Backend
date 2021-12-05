package com.carvajal.ebusiness.service;

import java.util.List;
import java.util.Optional;

import com.carvajal.ebusiness.dto.ClientDTO;
import com.carvajal.ebusiness.model.Client;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface ClientService extends UserDetailsService{
    public Optional<Client> addClient(Client client);

    public List<ClientDTO> getAllClients();

}
