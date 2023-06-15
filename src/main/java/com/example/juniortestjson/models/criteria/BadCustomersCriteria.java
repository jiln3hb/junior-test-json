package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class BadCustomersCriteria implements Criteria {
    private int badCustomers;

    @Override
    public String toString() {
        return String.valueOf(badCustomers);
    }
}
