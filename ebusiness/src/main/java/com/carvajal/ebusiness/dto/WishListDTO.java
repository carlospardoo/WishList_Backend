package com.carvajal.ebusiness.dto;

import java.time.LocalDateTime;

import com.carvajal.ebusiness.model.Client;
import com.carvajal.ebusiness.model.Product;

public class WishListDTO {
    private long id;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private int quantity;

    private Client client;

    private Product product;

    private String state;

    public WishListDTO() {

    }

    public WishListDTO(long id, LocalDateTime createDate, LocalDateTime updateDate, 
        int quantity, Client client, Product product, String state) {
        this.id = id;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.quantity = quantity;
        this.client = client;
        this.product = product;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "WishListDTO [client=" + client + ", createDate=" + createDate + ", id=" + id + ", product=" + product
                + ", quantity=" + quantity + ", state=" + state + ", updateDate=" + updateDate + "]";
    }
    
}
