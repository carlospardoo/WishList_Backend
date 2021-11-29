package com.carvajal.ebusiness.service.impl;

import com.carvajal.ebusiness.dao.WishListHisDAO;
import com.carvajal.ebusiness.model.WishListHis;
import com.carvajal.ebusiness.service.WishListHisService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishListHisServiceImpl implements WishListHisService{

    @Autowired
    private WishListHisDAO wlhDAO;

    @Override
    public void addWishListHis(WishListHis parameters) {
        wlhDAO.save(parameters);
    }
    
}
