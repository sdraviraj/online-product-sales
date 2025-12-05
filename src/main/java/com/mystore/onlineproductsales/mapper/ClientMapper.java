package com.mystore.onlineproductsales.mapper;

import com.mystore.onlineproductsales.domain.model.Client;
import com.mystore.onlineproductsales.domain.model.IndividualClient;
import com.mystore.onlineproductsales.domain.model.ProfessionalClient;
import com.mystore.onlineproductsales.dto.ClientDto;

public final class ClientMapper {
    private ClientMapper() {}

    public static Client toDomain(ClientDto dto) {

        if (dto == null) {
            throw new IllegalArgumentException("Client data is missing");
        }

        // Professional client
        if (dto.annualRevenue() != null) {
            ProfessionalClient pro = new ProfessionalClient();
            pro.setClientId(dto.clientId());
            pro.setCompanyName(dto.companyName());
            pro.setVatNumber(dto.vatNumber());
            pro.setRegistrationNumber(dto.registrationNumber());
            pro.setAnnualRevenue(dto.annualRevenue());
            return pro;
        }

        // Individual client
        IndividualClient ind = new IndividualClient();
        ind.setClientId(dto.clientId());
        ind.setFirstName(dto.firstName());
        ind.setLastName(dto.lastName());
        return ind;
    }
}
