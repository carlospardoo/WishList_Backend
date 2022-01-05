package com.carvajal.ebusiness.controller;

import java.util.List;

import com.carvajal.ebusiness.dto.ClientDTO;
import com.carvajal.ebusiness.service.impl.ClientServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ClientServiceImpl clService;

    @GetMapping(value = "/load-clients", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.FOUND)
    public List<ClientDTO> sendFullclients(){
        List<ClientDTO> clients = clService.getAllClients();
        if (clients.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return clients;
        }
    }

}
