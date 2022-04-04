package com.products.eCommerce.repository;

import com.products.eCommerce.entity.DeliveredDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveredDetailsRepository extends JpaRepository<DeliveredDetails,Integer> {
}
