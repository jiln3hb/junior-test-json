package com.example.juniortestjson.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PURCHASE")
public class PurchaseEntity {

    @Id
    @SequenceGenerator(name = "PURCHASE_ID_GEN", sequenceName = "PURCHASE_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PURCHASE_ID_GEN")
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CUSTOMER_ID")
    private CustomerEntity customer;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "PRODUCTS_ID")
    private Set<ProductEntity> products;

    @Column(name = "PURCHASE_DATE")
    private LocalDate purchaseDate;
}
