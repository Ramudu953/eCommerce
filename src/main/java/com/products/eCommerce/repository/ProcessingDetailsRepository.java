package com.products.eCommerce.repository;

import com.products.eCommerce.entity.ProcessingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessingDetailsRepository extends JpaRepository<ProcessingDetails,Integer> {
}
