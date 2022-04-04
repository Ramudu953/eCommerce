package com.products.eCommerce.repository;

import com.products.eCommerce.entity.SkuPriceDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuPriceDetailsRepository extends JpaRepository<SkuPriceDetails,Integer> {
}
