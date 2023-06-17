package com.example.juniortestjson.repository;

import com.example.juniortestjson.dto.CustomerEntityDTO;
import com.example.juniortestjson.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

    @Query(nativeQuery = true)
    List<CustomerEntityDTO> findByLastName(@Param("last_name") String lastName);
}
