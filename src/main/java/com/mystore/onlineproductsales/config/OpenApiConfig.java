package com.mystore.onlineproductsales.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productSalesApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Online Product Sales API")
                        .description("API documentation for shopping cart, pricing, and product management")
                        .version("1.0.0"));
    }
}

