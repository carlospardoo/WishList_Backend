package com.carvajal.ebusiness.dto;

public class ClientDTO {
    private long document;

    private String name;

    private String username;

    private String password;

    public ClientDTO() {

    }

    public ClientDTO(long document, String name, String username, String password) {
        this.document = document;
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

    @Override
    public String toString() {
        return "ClientDTO [document=" + document + ", name=" + name + ", password=" + password + ", username="
                + username + "]";
    }


}
