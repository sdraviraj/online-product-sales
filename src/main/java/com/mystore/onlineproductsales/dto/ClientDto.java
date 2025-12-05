package com.mystore.onlineproductsales.dto;

import jakarta.validation.constraints.NotNull;

public record ClientDto(
        ClientType type,
        @NotNull(message = "Client ID is required")
        String clientId,
        String firstName,
        String lastName,
        String companyName,
        String vatNumber,
        String registrationNumber,
        Double annualRevenue
) {
}
