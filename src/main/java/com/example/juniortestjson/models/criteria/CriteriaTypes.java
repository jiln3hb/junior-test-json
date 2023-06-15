package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public enum CriteriaTypes {

    LAST_NAME(Set.of("lastName")),
    PRODUCT(Set.of("productName", "minTimes")),
    PRICE(Set.of("minExpenses", "maxExpenses")),
    BAD_CUSTOMERS(Set.of("badCustomers"));

    private final Set<String> keySet;
}
