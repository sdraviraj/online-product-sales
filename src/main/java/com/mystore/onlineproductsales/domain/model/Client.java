package com.mystore.onlineproductsales.domain.model;

import lombok.Data;

@Data
public abstract class Client {

    private String clientId;

    protected Client() {
    }

    protected Client(String clientId) {
        this.clientId = clientId;
    }

/*    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }*/
}

