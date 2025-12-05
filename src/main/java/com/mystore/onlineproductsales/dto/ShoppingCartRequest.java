package com.mystore.onlineproductsales.dto;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public record ShoppingCartRequest(
        @NotNull(message = "Client is required")
        @Valid
        ClientDto client,

        @NotEmpty(message = "Cart cannot be empty")
        Map<ProductType, Integer> quantities
) {
}
