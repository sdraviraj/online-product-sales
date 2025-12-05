package com.mystore.onlineproductsales.controller;

import com.mystore.onlineproductsales.domain.model.Client;
import com.mystore.onlineproductsales.dto.ShoppingCartRequest;
import com.mystore.onlineproductsales.dto.ShoppingCartResponse;
import com.mystore.onlineproductsales.mapper.ClientMapper;
import com.mystore.onlineproductsales.service.ShoppingCartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/total")
    public ResponseEntity<ShoppingCartResponse> calculateTotal(@RequestBody ShoppingCartRequest request) {

        Client client = ClientMapper.toDomain(request.client());
        double total = shoppingCartService.calculateTotal(client, request.quantities());

        return ResponseEntity.ok(new ShoppingCartResponse(total));
    }
}
