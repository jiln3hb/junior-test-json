package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class PriceCriteria implements Criteria {
    private int minExpenses;

    private int maxExpenses;

    @Override
    public String toString() {
        return String.valueOf(minExpenses) + ", " + String.valueOf(maxExpenses);
    }
}
