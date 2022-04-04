package com.products.eCommerce.repository;

import com.products.eCommerce.entity.ReturnedDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnedDetailsRepository extends JpaRepository<ReturnedDetails,Integer> {
}
