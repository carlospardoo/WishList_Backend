package com.carvajal.ebusiness.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist_his")
//@IdClass(value = WishList.class)
public class WishListHis implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wlh_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "wlh_wishlist_id", referencedColumnName = "wl_id")
    private WishList wishList;

    @Column(name = "wlh_createdate")
    private LocalDateTime createDate;

    @Column(name = "wlh_updatedate")
    private LocalDateTime updateDate;

    @Column(name = "wlh_quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "wlh_client", referencedColumnName = "cli_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "wlh_product", referencedColumnName = "pro_id")
    private Product product;

    @Column(name = "wlh_operation")
    private String operation;

    @Column(name = "wlh_state")
    private String state;

    public WishListHis() {

    }

    public WishListHis(long id, WishList wishList, String operation) {
        this.id = id;
        this.wishList = wishList;
        this.createDate = wishList.getCreateDate();
        this.updateDate = wishList.getUpdateDate();
        this.quantity = wishList.getQuantity();
        this.client = wishList.getClient();
        this.product = wishList.getProduct();
        this.state = wishList.getState();
        this.operation = operation;
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


    public WishList getWishList() {
        return wishList;
    }


    public void setWishList(WishList wishList) {
        this.wishList = wishList;
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

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "WishListHis [client=" + client + ", createDate=" + createDate + ", id=" + id + ", operation="
                + operation + ", product=" + product + ", quantity=" + quantity + ", state=" + state + ", updateDate="
                + updateDate + ", wishList=" + wishList + "]";
    }


}
