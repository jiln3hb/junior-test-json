package com.example.juniortestjson.repository;

import com.example.juniortestjson.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

    List<CustomerEntity> findByLastName(String lastName);

    List<CustomerEntity> findByProductName(String productName);
}
