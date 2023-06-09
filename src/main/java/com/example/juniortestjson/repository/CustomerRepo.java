package com.example.juniortestjson.repository;

import com.example.juniortestjson.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
}
