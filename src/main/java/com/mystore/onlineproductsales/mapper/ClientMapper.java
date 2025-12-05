package com.mystore.onlineproductsales.mapper;

import com.mystore.onlineproductsales.domain.model.Client;
import com.mystore.onlineproductsales.domain.model.IndividualClient;
import com.mystore.onlineproductsales.domain.model.ProfessionalClient;
import com.mystore.onlineproductsales.dto.ClientDto;

public final class ClientMapper {
    private ClientMapper() {}

    public static Client toDomain(ClientDto dto) {

        if (dto == null || dto.type() == null) {
            throw new IllegalArgumentException("Client type must be provided");
        }

        return switch (dto.type()) {

            case INDIVIDUAL -> new IndividualClient(
                    dto.clientId(),
                    dto.firstName(),
                    dto.lastName()
            );

            case PROFESSIONAL -> {
                if (dto.annualRevenue() == null) {
                    throw new IllegalArgumentException(
                            "Annual revenue is required for professional client"
                    );
                }
                yield new ProfessionalClient(
                        dto.clientId(),
                        dto.companyName(),
                        dto.vatNumber(),
                        dto.registrationNumber(),
                        dto.annualRevenue()
                );
            }
        };
    }
}
