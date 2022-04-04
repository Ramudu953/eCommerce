package com.products.eCommerce.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productCode;
    private String productName;
    private String description;
    @OneToMany(mappedBy = "productDetails")
    private List<SkuProductDetails> skuProductDetails;

    public ProductDetails() {
    }

    public Integer getProductCode() {
        return productCode;
    }

    public void setProductCode(Integer productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SkuProductDetails> getSkuProductDetails() {
        return skuProductDetails;
    }

    public void setSkuProductDetails(List<SkuProductDetails> skuProductDetails) {
        this.skuProductDetails = skuProductDetails;
    }
}
