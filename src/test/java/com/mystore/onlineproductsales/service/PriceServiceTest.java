package com.mystore.onlineproductsales.service;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import com.mystore.onlineproductsales.domain.model.IndividualClient;
import com.mystore.onlineproductsales.domain.model.ProductEntity;
import com.mystore.onlineproductsales.domain.model.ProfessionalClient;
import com.mystore.onlineproductsales.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private PriceService priceService;

    private ProductEntity mockProductEntity() {
        ProductEntity product = new ProductEntity();
        product.setProductType(ProductType.HIGH_END_PHONE);
        product.setIndividualPrice(1500);
        product.setProLowRevenuePrice(1150);
        product.setProHighRevenuePrice(1000);
        return product;
    }

    @Test
    void testPriceForIndividualClient() {
        when(productRepository.findById(ProductType.HIGH_END_PHONE))
                .thenReturn(Optional.of(mockProductEntity()));

        IndividualClient client = new IndividualClient();
        double price = priceService.getPrice(ProductType.HIGH_END_PHONE, client);

        assertEquals(1500, price);
    }

    @Test
    void testPriceForHighRevenueProfessional() {
        when(productRepository.findById(ProductType.HIGH_END_PHONE))
                .thenReturn(Optional.of(mockProductEntity()));

        ProfessionalClient client = new ProfessionalClient();
        client.setAnnualRevenue(12_000_000);

        double price = priceService.getPrice(ProductType.HIGH_END_PHONE, client);

        assertEquals(1000, price);
    }

    @Test
    void testPriceForLowRevenueProfessional() {
        when(productRepository.findById(ProductType.HIGH_END_PHONE))
                .thenReturn(Optional.of(mockProductEntity()));

        ProfessionalClient client = new ProfessionalClient();
        client.setAnnualRevenue(5_000_000);

        double price = priceService.getPrice(ProductType.HIGH_END_PHONE, client);

        assertEquals(1150, price);
    }
}




