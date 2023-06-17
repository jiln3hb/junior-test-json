package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PriceCriteria implements Criteria {
    private int minExpenses;

    private int maxExpenses;

    @Override
    public String toString() {
        return "minExpenses: " + String.valueOf(minExpenses) + ", maxExpenses: " + String.valueOf(maxExpenses);
    }
}
