package com.carvajal.ebusiness.model;

import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
    
    @Id
    @Column(name = "rol_id")
    private int id;

    @Column(name = "rol_name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "rol_client", 
        joinColumns = @JoinColumn(name = "rlc_rol", referencedColumnName = "rol_id"),
        inverseJoinColumns = @JoinColumn(name = "rlc_client", referencedColumnName = "cli_id") 
    )
    private HashSet<Client> clients;

    public Rol() {

    }

    public Rol(int id, String name, HashSet<Client> clients) {
        this.id = id;
        this.name = name;
        this.clients = clients;
    }
    
    public Rol(String name, HashSet<Client> clients) {
        this.name = name;
        this.clients = clients;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Client> getClients() {
        return clients;
    }

    public void setClients(HashSet<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Rol [clients=" + clients + ", id=" + id + ", name=" + name + "]";
    }

}
