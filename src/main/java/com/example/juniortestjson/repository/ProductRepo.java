package com.example.juniortestjson.repository;

import com.example.juniortestjson.entity.CustomerEntity;
import com.example.juniortestjson.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
}
