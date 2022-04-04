package com.products.eCommerce.repository;

import com.products.eCommerce.entity.SkuProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuProductDetailsRepository extends JpaRepository<SkuProductDetails,Integer> {
}
