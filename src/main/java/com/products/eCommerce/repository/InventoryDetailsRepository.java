package com.products.eCommerce.repository;

import com.products.eCommerce.entity.InventoryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryDetailsRepository extends JpaRepository<InventoryDetails,Integer> {
}
