package com.products.eCommerce.model;

import java.util.List;

public class ProductModel {
    private Integer productCode;
    private String productName;
    private String description;
    private List<SkuProduct> skuProducts;

    public ProductModel() {
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

    public List<SkuProduct> getSkuProducts() {
        return skuProducts;
    }

    public void setSkuProducts(List<SkuProduct> skuProducts) {
        this.skuProducts = skuProducts;
    }
}
