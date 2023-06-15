package com.example.juniortestjson.repository;

import com.example.juniortestjson.dto.CustomerEntityDTO;
import com.example.juniortestjson.dto.ProductDTO;
import com.example.juniortestjson.entity.CustomerEntity;
import com.example.juniortestjson.entity.ProductEntity;
import com.example.juniortestjson.entity.PurchaseEntity;
import jakarta.persistence.SqlResultSetMapping;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchaseEntity, Long> {
    @Query(nativeQuery = true)
    List<CustomerEntityDTO> findCustomersByProductNameAndNumberOfPurchases(@Param("productName") String productName, @Param("minTimes") int minTimes);

    @Query(nativeQuery = true)
    List<CustomerEntityDTO> findCustomersByMinAndMaxExpenses(@Param("minExpenses") int minExpenses, @Param("maxExpenses") int maxExpenses);

    @Query(nativeQuery = true)
    List<CustomerEntityDTO> findBadCustomers(@Param("badCustomers") int badCustomers);

    @Query(nativeQuery = true)
    List<Long> findCustomerIdsWithPurchasesInPeriod(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<ProductDTO> findStat(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
