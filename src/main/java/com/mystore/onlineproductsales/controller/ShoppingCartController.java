package com.mystore.onlineproductsales.controller;

import com.mystore.onlineproductsales.domain.model.Client;
import com.mystore.onlineproductsales.dto.ShoppingCartRequest;
import com.mystore.onlineproductsales.dto.ShoppingCartResponse;
import com.mystore.onlineproductsales.mapper.ClientMapper;
import com.mystore.onlineproductsales.service.ShoppingCartService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
@Validated
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/total")
    public ResponseEntity<ShoppingCartResponse> calculateTotal( @Valid @RequestBody ShoppingCartRequest request) {

        Client client = ClientMapper.toDomain(request.client());
        double total = shoppingCartService.calculateTotal(client, request.quantities());

        return ResponseEntity.ok(new ShoppingCartResponse(total));
    }
}
