package com.mystore.onlineproductsales.domain.model;

public class ProfessionalClient extends Client {
    private String companyName;
    private String vatNumber;
    private String registrationNumber;
    private double annualRevenue;

    public ProfessionalClient(){
        super();

    }

    public ProfessionalClient(String clientId,
                              String companyName,
                              String vatNumber,
                              String registrationNumber,
                              double annualRevenue) {
        super(clientId);
        this.companyName = companyName;
        this.vatNumber = vatNumber;
        this.registrationNumber = registrationNumber;
        this.annualRevenue = annualRevenue;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public double getAnnualRevenue() {
        return annualRevenue;
    }

    public void setAnnualRevenue(double annualRevenue) {
        this.annualRevenue = annualRevenue;
    }
}
