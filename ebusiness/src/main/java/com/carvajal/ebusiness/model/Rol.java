package com.carvajal.ebusiness.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private int id;

    @Column(name = "rol_name", nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE) //, cascade = CascadeType.ALL
    @JoinTable(name = "rol_client", 
        joinColumns = @JoinColumn(name = "rlc_rol", referencedColumnName = "rol_id"),
        inverseJoinColumns = @JoinColumn(name = "rlc_client", referencedColumnName = "cli_id") 
    )
    private Set<Client> clients = new HashSet<>();

    public Rol() {
        super();
        // this.clients = new HashSet<>();
    }

    public Rol(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Rol(String name) {
        this.name = name;
        // this.clients = clients;
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

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client){
        this.clients.add(client);
        client.getRoles().add(this);
    }

    public void removeClient(Client client){
        this.clients.remove(client);
        client.getRoles().remove(this);
    }

    @Override
    public String toString() {
        return "Rol [clients=" + clients + ", id=" + id + ", name=" + name + "]";
    }

}
