package com.mystore.onlineproductsales.domain.model;

import com.mystore.onlineproductsales.domain.enums.ProductType;
import jakarta.persistence.*;


@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "product_type")
    private ProductType productType;

    @Column(name = "individual_price")
    private double individualPrice;

    @Column(name = "pro_low_revenue_price")
    private double proLowRevenuePrice;

    @Column(name = "pro_high_revenue_price")
    private double proHighRevenuePrice;

    public ProductEntity() {
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public double getIndividualPrice() {
        return individualPrice;
    }

    public void setIndividualPrice(double individualPrice) {
        this.individualPrice = individualPrice;
    }

    public double getProLowRevenuePrice() {
        return proLowRevenuePrice;
    }

    public void setProLowRevenuePrice(double proLowRevenuePrice) {
        this.proLowRevenuePrice = proLowRevenuePrice;
    }

    public double getProHighRevenuePrice() {
        return proHighRevenuePrice;
    }

    public void setProHighRevenuePrice(double proHighRevenuePrice) {
        this.proHighRevenuePrice = proHighRevenuePrice;
    }

}
