package com.products.eCommerce.entity;

import javax.persistence.*;

@Entity
public class SkuProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer skuCode;
    private String size;
    @ManyToOne(cascade = CascadeType.ALL)
    private ProductDetails productDetails;
    @OneToOne(mappedBy = "skuProductDetails")
    private SkuPriceDetails skuPriceDetails;
    @OneToOne(mappedBy = "skuProductDetails")
    private CartDetails cartDetails;
    @OneToOne(mappedBy = "skuProductDetails")
    private InventoryDetails inventoryDetails;

    public SkuProductDetails() {
    }

    public Integer getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(Integer skuCode) {
        this.skuCode = skuCode;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public ProductDetails getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(ProductDetails productDetails) {
        this.productDetails = productDetails;
    }

    public SkuPriceDetails getSkuPriceDetails() {
        return skuPriceDetails;
    }

    public void setSkuPriceDetails(SkuPriceDetails skuPriceDetails) {
        this.skuPriceDetails = skuPriceDetails;
    }

    public CartDetails getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(CartDetails cartDetails) {
        this.cartDetails = cartDetails;
    }

    public InventoryDetails getInventoryDetails() {
        return inventoryDetails;
    }

    public void setInventoryDetails(InventoryDetails inventoryDetails) {
        this.inventoryDetails = inventoryDetails;
    }
}
