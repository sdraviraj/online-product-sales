package com.mystore.onlineproductsales.service;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import com.mystore.onlineproductsales.domain.model.IndividualClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.jupiter.api.extension.ExtendWith;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoppingCartServiceTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private ShoppingCartService cartService;

    @Test
    void testCartTotal() {
        IndividualClient client = new IndividualClient();

        when(priceService.getPrice(ProductType.HIGH_END_PHONE, client))
                .thenReturn(1500.0);
        when(priceService.getPrice(ProductType.LAPTOP, client))
                .thenReturn(1200.0);

        Map<ProductType, Integer> quantities = new EnumMap<>(ProductType.class);
        quantities.put(ProductType.HIGH_END_PHONE, 1);
        quantities.put(ProductType.LAPTOP, 2);

        double total = cartService.calculateTotal(client, quantities);

        assertEquals(3900.0, total);
    }

    @Test
    void testEmptyCart() {
        double total = cartService.calculateTotal(new IndividualClient(), Map.of());
        assertEquals(0.0, total);
    }

    @Test
    void testNullOrZeroQuantitiesAreIgnored() {
        IndividualClient client = new IndividualClient();

        Map<ProductType, Integer> quantities = new EnumMap<>(ProductType.class);
        quantities.put(ProductType.HIGH_END_PHONE, 0);
        quantities.put(ProductType.LAPTOP, null);

        double total = cartService.calculateTotal(client, quantities);

        assertEquals(0.0, total);
    }

}


