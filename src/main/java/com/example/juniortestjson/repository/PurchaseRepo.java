package com.example.juniortestjson.repository;

import com.example.juniortestjson.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepo extends JpaRepository<ProductEntity, Long> {
}