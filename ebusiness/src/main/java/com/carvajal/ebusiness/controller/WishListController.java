package com.carvajal.ebusiness.controller;

import java.util.List;

import com.carvajal.ebusiness.dto.ClientDTO;
import com.carvajal.ebusiness.dto.WishListDTO;
import com.carvajal.ebusiness.service.impl.ClientServiceImpl;
//import com.carvajal.ebusiness.service.WishListService;
import com.carvajal.ebusiness.service.impl.WishListServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WishListServiceImpl wlService;

    @Autowired
    private ClientServiceImpl cService;

    /**
     * 
     * @param client Client object. Required client id
     * 
     * @return List of wishlist applied to the client
     */
    @GetMapping(value = "/load")
    @ResponseStatus(value = HttpStatus.FOUND)
    public List<WishListDTO> sendClientWishList(@RequestBody ClientDTO client){
        logger.info("RequestBody: "+client.toString());
        cService.addClient(cService.clientDefault());

        List<WishListDTO> data = wlService.loadClientWishList(client);
        if(data.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return data;
    }

    @PostMapping(value = "/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public WishListDTO resAddWishList(@RequestParam WishListDTO wishList){
        return null;
    }

    @PutMapping(value = "/update")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public WishListDTO resUpdateWishList(@RequestParam WishListDTO wishList){
        return null;
    }

    @DeleteMapping(value = "/delete")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public boolean resDeleteWishList(@RequestParam WishListDTO wishList){
        return true;
    }

}
