package com.mystore.onlineproductsales.domain.model;


public class IndividualClient extends Client{

    private String firstName;
    private String lastName;

    public IndividualClient() {
    }

    public IndividualClient(String clientId, String firstName, String lastName) {
        super(clientId);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
