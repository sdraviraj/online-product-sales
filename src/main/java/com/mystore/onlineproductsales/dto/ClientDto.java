package com.mystore.onlineproductsales.dto;

public record ClientDto(
        ClientType type,
        String clientId,
        String firstName,
        String lastName,
        String companyName,
        String vatNumber,
        String registrationNumber,
        Double annualRevenue
) {
}
