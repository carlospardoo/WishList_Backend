package com.carvajal.ebusiness.service;

import java.util.List;
import java.util.Optional;

import com.carvajal.ebusiness.dto.ClientDTO;
import com.carvajal.ebusiness.model.Client;

public interface ClientService {
    public Optional<Client> addClient(Client client);

    public List<ClientDTO> getAllClients();

}
