package com.mystore.onlineproductsales.service;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import com.mystore.onlineproductsales.domain.model.Client;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShoppingCartService {

    private final PriceService priceService;

    public ShoppingCartService(PriceService priceService) {
        this.priceService = priceService;
    }

    public double calculateTotal(Client client, Map<ProductType, Integer> quantities) {

        if (quantities == null || quantities.isEmpty()) {
            return 0.0;
        }

        return quantities.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != null && entry.getValue() > 0)
                .mapToDouble(entry -> {
                    double price = priceService.getPrice(entry.getKey(), client);
                    return price * entry.getValue();
                })
                .sum();
    }
}
