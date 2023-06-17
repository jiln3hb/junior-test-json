package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BadCustomersCriteria implements Criteria {
    private int badCustomers;

    @Override
    public String toString() {
        return "badCustomers: " + String.valueOf(badCustomers);
    }
}
