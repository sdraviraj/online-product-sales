package com.mystore.onlineproductsales.repository;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import com.mystore.onlineproductsales.domain.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, ProductType> {
}
