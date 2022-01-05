package com.carvajal.ebusiness.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @Fetch(FetchMode.JOIN)
    @ManyToMany(mappedBy = "clients", fetch = FetchType.LAZY, cascade = CascadeType.MERGE) //, cascade = CascadeType.ALL
    private Set<Rol> roles = new HashSet<>();

    public Client() {
        super();
        // this.roles = new HashSet<>();
    }

    public Client(long document, String name, String username, String password) {
        this.document = document;
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    public Client(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public void addRol(Rol rol){
        this.roles.add(rol);
        rol.getClients().add(this);
    }

    public void removeRol(Rol rol){
        this.roles.remove(rol);
        rol.getClients().remove(this);
    }

    @Override
    public String toString() {
        return "Client [document=" + document + ", name=" + name + ", password=" + password + ", roles=" + roles
                + ", username=" + username + "]";
    }

}
