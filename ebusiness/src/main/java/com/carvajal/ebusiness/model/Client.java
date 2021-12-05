package com.carvajal.ebusiness.model;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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

    @Column(name = "cli_username", unique = true)
    private String username;

    @Column(name = "cli_password")
    private String password;

    @ManyToMany(mappedBy = "clients")
    private HashSet<Rol> roles;

    public Client() {

    }

    public Client(long document, String name, String username, String password, HashSet<Rol> roles) {
        this.document = document;
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
    
    public Client(String name, String username, String password, HashSet<Rol> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HashSet<Rol> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<Rol> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Client [document=" + document + ", name=" + name + ", password=" + password + ", roles=" + roles
                + ", username=" + username + "]";
    }

}
