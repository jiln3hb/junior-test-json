package com.example.juniortestjson.models.output.stat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor

public class StatOutputCustomer {

    private String name;

    private String[] products;

    private BigDecimal totalExpenses;
}
