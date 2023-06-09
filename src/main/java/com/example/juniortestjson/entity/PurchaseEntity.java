package com.example.juniortestjson.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PURCHASE")
public class PurchaseEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER")
    private CustomerEntity customer;

    @ManyToMany
    @JoinColumn(name = "PRODUCT")
    private Set<ProductEntity> products;

    @Column(name = "PURCHASE_DATE")
    private LocalDateTime purchaseDate;
}
