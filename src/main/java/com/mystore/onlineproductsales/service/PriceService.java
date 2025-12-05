package com.mystore.onlineproductsales.service;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import com.mystore.onlineproductsales.domain.model.Client;
import com.mystore.onlineproductsales.domain.model.IndividualClient;
import com.mystore.onlineproductsales.domain.model.ProductEntity;
import com.mystore.onlineproductsales.domain.model.ProfessionalClient;
import com.mystore.onlineproductsales.domain.rules.PricingRules;
import com.mystore.onlineproductsales.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    private final ProductRepository productRepository;

    public PriceService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public double getPrice(ProductType productType, Client client) {

        ProductEntity entity = productRepository.findById(productType)
                .orElseThrow(() -> new IllegalStateException("Product not found: " + productType));

        if (client instanceof IndividualClient) {
            return entity.getIndividualPrice();
        }

        if (client instanceof ProfessionalClient proClient) {
            boolean highRevenue = proClient.getAnnualRevenue() > PricingRules.HIGH_REVENUE_THRESHOLD;
            return highRevenue ? entity.getProHighRevenuePrice() : entity.getProLowRevenuePrice();
        }

        throw new IllegalArgumentException("Unknown client type: " + client.getClass().getSimpleName());
    }
}


