package com.mystore.onlineproductsales.service;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import com.mystore.onlineproductsales.domain.model.Client;
import com.mystore.onlineproductsales.domain.model.IndividualClient;
import com.mystore.onlineproductsales.domain.model.ProductEntity;
import com.mystore.onlineproductsales.domain.model.ProfessionalClient;
import com.mystore.onlineproductsales.domain.rules.PricingRules;
import com.mystore.onlineproductsales.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PriceService {

    private final ProductRepository productRepository;

    public PriceService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public double getPrice(ProductType productType, Client client) {
        log.info("Calculating price for product {} and client {}", productType, client.getClientId());

        ProductEntity entity = productRepository.findById(productType)
                .orElseThrow(() -> {
                    log.error("Product {} not found in DB", productType);
                    return new IllegalStateException("Product not found: " + productType);
                });

        double price;
        if (client instanceof IndividualClient) {
            price = entity.getIndividualPrice();
        } else if (client instanceof ProfessionalClient proClient) {
            boolean highRevenue = proClient.getAnnualRevenue() > PricingRules.HIGH_REVENUE_THRESHOLD;
            price = highRevenue ? entity.getProHighRevenuePrice() : entity.getProLowRevenuePrice();
        } else {
            throw new IllegalArgumentException("Unknown client type");
        }

        log.debug("Resolved price = {}", price);
        return price;
    }
}


