package com.example.juniortestjson.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class SearchCriterias {

    private String lastName;

    private Map<String, Object> productCriteria;

    private Map<String, Integer> priceCriteria;

    private Integer badCustomers;

    @Override
    public String toString() {
        return "lastName: " + lastName + " productName: " + productCriteria.get("productName") + " minTimes: "
                + productCriteria.get("minTimes") + " minExpenses: " + priceCriteria.get("minExpenses") + " maxExpenses: "
                + priceCriteria.get("maxExpenses") + " badCustomers: " + badCustomers;
    }
}
