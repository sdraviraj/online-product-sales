package com.mystore.onlineproductsales.controller;

import com.mystore.onlineproductsales.controller.ShoppingCartController;
import com.mystore.onlineproductsales.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ShoppingCartController.class)
@Import(ShoppingCartControllerTest.TestConfig.class)
class ShoppingCartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ShoppingCartService shoppingCartService;

    static class TestConfig {

        @Bean
        public ShoppingCartService shoppingCartService() {
            return Mockito.mock(ShoppingCartService.class);
        }
    }

    @Test
    void calculateTotalEndpointReturnsExpectedResponse() throws Exception {

        Mockito.when(shoppingCartService.calculateTotal(any(), any()))
                .thenReturn(3000.0);

        String json = """
        {
          "client": {
            "type": "INDIVIDUAL",
            "clientId": "C001",
            "firstName": "John",
            "lastName": "Doe"
          },
          "quantities": {
            "HIGH_END_PHONE": 1,
            "LAPTOP": 1
          }
        }
        """;

        mockMvc.perform(post("/api/cart/total")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPrice").value(3000.0));
    }
}
