package com.products.eCommerce.service;

import com.products.eCommerce.entity.InventoryDetails;
import com.products.eCommerce.entity.OrderDetails;
import com.products.eCommerce.entity.SkuProductDetails;
import com.products.eCommerce.repository.InventoryDetailsRepository;
import com.products.eCommerce.repository.OrderDetailsRepository;
import com.products.eCommerce.repository.SkuProductDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryDetailsRepository inventoryDetailsRepository;
    @Autowired
    private SkuProductDetailsRepository skuProductDetailsRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public String addInventory(Integer skuCode,Integer quantity){
        Optional<SkuProductDetails> skuProductDetails=skuProductDetailsRepository.findById(skuCode);
        if(skuProductDetails.isPresent()) {
            if (skuProductDetails.get().getSkuCode() >= skuCode) {
                InventoryDetails ind = new InventoryDetails();
                ind.setSkuCode(skuCode);
                ind.setQuantity(quantity);
                ind.setSkuProductDetails(skuProductDetails.get());
                inventoryDetailsRepository.save(ind);
                return "Inventory Added";
            }
        }
        return "Inventory not Added";
    }

}
