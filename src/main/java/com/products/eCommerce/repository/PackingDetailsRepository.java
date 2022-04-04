package com.products.eCommerce.repository;

import com.products.eCommerce.entity.PackingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackingDetailsRepository extends JpaRepository<PackingDetails,Integer> {
}
