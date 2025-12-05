package com.mystore.onlineproductsales.service;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import com.mystore.onlineproductsales.domain.model.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class ShoppingCartService {

    private final PriceService priceService;

    public ShoppingCartService(PriceService priceService) {
        this.priceService = priceService;
    }

    public double calculateTotal(Client client, Map<ProductType, Integer> quantities) {
        log.info("Calculating cart total for client {}", client.getClientId());
        if (quantities == null || quantities.isEmpty()) {
            log.warn("Empty shopping cart");
            return 0.0;
        }

        double total = quantities.entrySet()
                .stream()
                .filter(entry -> entry.getValue() != null && entry.getValue() > 0)
                .mapToDouble(entry -> {
                    double price = priceService.getPrice(entry.getKey(), client);
                    log.debug("Product {} qty {} => {}", entry.getKey(), entry.getValue(), price);
                    return price * entry.getValue();
                })
                .sum();
        log.info("Total calculated for client {} = {}", client.getClientId(), total);
        return total;
    }
}
