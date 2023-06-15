package com.example.juniortestjson.entity;

import com.example.juniortestjson.dto.CustomerEntityDTO;
import com.example.juniortestjson.dto.ProductDTO;
import com.google.common.collect.Multiset;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Bag;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedNativeQuery(name = "PurchaseEntity.findCustomersByProductNameAndNumberOfPurchases",
        query = "SELECT c.first_Name, c.last_name FROM customer c JOIN purchase p ON c.id = p.customer_id " +
                "JOIN purchase_products pp ON p.id = pp.purchase_entity_id JOIN product pr ON pp.products_id = pr.id WHERE pr.name = :productName " +
                "GROUP BY c.id HAVING COUNT(*) >= :minTimes",
        resultSetMapping = "Mapping.CustomerEntityDTO")
@NamedNativeQuery(name = "PurchaseEntity.findCustomersByMinAndMaxExpenses",
        query = "SELECT c.first_name, c.last_name, SUM(pr.price) FROM customer c JOIN purchase p ON c.id = p.customer_id " +
                "JOIN purchase_products pp ON p.id = pp.purchase_entity_id JOIN product pr ON pp.products_id = pr.id " +
                "GROUP BY c.id HAVING (SUM(pr.price) >= :minExpenses AND SUM(pr.price) <= :maxExpenses)",
        resultSetMapping = "Mapping.CustomerEntityDTO")
@NamedNativeQuery(name = "PurchaseEntity.findBadCustomers",
        query = "SELECT c.first_name, c.last_name FROM customer c JOIN purchase p ON c.id = p.customer_id " +
                "JOIN purchase_products pp ON p.id = pp.purchase_entity_id JOIN product pr ON pp.products_id = pr.id " +
                "GROUP BY c.id ORDER BY COUNT(pr.id) LIMIT :badCustomers",
        resultSetMapping = "Mapping.CustomerEntityDTO")

@NamedNativeQuery(name = "PurchaseEntity.findStat",
        query = "SELECT DISTINCT p.customer_id, pr.name, SUM(pr.price) AS total_expenses FROM purchase p JOIN purchase_products pp ON p.id = pp.purchase_entity_id " +
                "JOIN product pr ON pp.products_id = pr.id WHERE p.purchase_date BETWEEN :startDate AND :endDate GROUP BY p.customer_id, pr.id ORDER BY total_expenses DESC",
        resultSetMapping = "Mapping.ProductDTO")
@SqlResultSetMapping(name = "Mapping.ProductDTO", classes = @ConstructorResult(targetClass = ProductDTO.class,
        columns = {@ColumnResult(name = "customer_id", type = Long.class), @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "total_expenses", type = BigDecimal.class)}))
@Entity
@Table(name = "PURCHASE")
public class PurchaseEntity {

    @Id
    @SequenceGenerator(name = "PURCHASE_ID_GEN", sequenceName = "PURCHASE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PURCHASE_ID_GEN")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    private Set<ProductEntity> products;

    @Column(name = "PURCHASE_DATE")
    private LocalDate purchaseDate;
}
