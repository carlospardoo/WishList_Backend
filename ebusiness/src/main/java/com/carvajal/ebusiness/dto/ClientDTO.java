package com.carvajal.ebusiness.dto;

public class ClientDTO {
    private long document;

    private String name;

    private String username;

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
        return "ClientDTO [document=" + document + ", name=" + name + ", username=" + username + "]";
    }

}
