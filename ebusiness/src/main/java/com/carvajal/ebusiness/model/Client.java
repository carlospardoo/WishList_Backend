package com.carvajal.ebusiness.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client implements Serializable{

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private long document;

    @Column(name = "cli_name")
    private String name;

    @Column(name = "cli_username")
    private String username;

    public Client() {

    }

    public Client(long document, String name, String username) {
        this.document = document;
        this.name = name;
        this.username = username;
    }

    public long getDocument() {
        return document;
    }

    public void setDocument(long document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Client [document=" + document + ", name=" + name + ", username=" + username + "]";
    }

}
