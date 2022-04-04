package com.products.eCommerce.service;

import com.products.eCommerce.entity.ProductDetails;
import com.products.eCommerce.entity.SkuPriceDetails;
import com.products.eCommerce.entity.SkuProductDetails;
import com.products.eCommerce.model.ProductModel;
import com.products.eCommerce.repository.ProductDetailsRepository;
import com.products.eCommerce.repository.SkuPriceDetailsRepository;
import com.products.eCommerce.repository.SkuProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductDetailsRepository productDetailsRepository;
    @Autowired
    private SkuProductDetailsRepository skuProductDetailsRepository;
    @Autowired
    private SkuPriceDetailsRepository skuPriceDetailsRepository;

    public void addProduct(ProductModel productModel) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductName(productModel.getProductName());
        productDetails.setDescription(productModel.getDescription());
        productDetailsRepository.save(productDetails);

        productModel.getSkuProducts().stream().forEach(sku -> {
            SkuProductDetails skuProduct = new SkuProductDetails();
            skuProduct.setSize(sku.getSize());
            SkuPriceDetails skuPrice = new SkuPriceDetails();
            skuPrice.setSkuCode(sku.getSkuCode());
            skuPrice.setPrice(sku.getPrice());
            skuProduct.setProductDetails(productDetails);
            skuPrice.setSkuProductDetails(skuProduct);
            skuProductDetailsRepository.save(skuProduct);
            skuPriceDetailsRepository.save(skuPrice);
        });

    }
}
