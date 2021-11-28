package com.carvajal.ebusiness.service.impl;

import java.util.Optional;

import com.carvajal.ebusiness.dao.ClientDAO;
import com.carvajal.ebusiness.model.Client;
import com.carvajal.ebusiness.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO cliDAO;

    public Client clientDefault(){
        Client cli1 = new Client(1569874620, "carlos", "postgres");
        return cli1;
    }

    @Override
    public Optional<Client> addClient(Client client) {
        if(Optional.of(client).isPresent()){
            Client aux = cliDAO.save(client);
            return Optional.of(aux);
        }
        else{
            return Optional.empty();
        }
    }
}
