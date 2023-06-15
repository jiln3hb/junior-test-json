package com.example.juniortestjson.repository;

import com.example.juniortestjson.dto.CustomerEntityDTO;
import com.example.juniortestjson.entity.CustomerEntity;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

    @Query(nativeQuery = true)
    List<CustomerEntityDTO> findByLastName(@Param("last_name") String lastName);

}
