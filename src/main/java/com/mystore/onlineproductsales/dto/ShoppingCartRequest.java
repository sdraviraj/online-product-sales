package com.mystore.onlineproductsales.dto;

import com.mystore.onlineproductsales.domain.enums.ProductType;

import java.util.Map;

public record ShoppingCartRequest(
        ClientDto client,
        Map<ProductType, Integer> quantities
) {
}
