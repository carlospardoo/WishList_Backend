package com.carvajal.ebusiness.service;

import java.util.Optional;

import com.carvajal.ebusiness.model.Client;

public interface ClientService {
    public Optional<Client> addClient(Client client);
}
