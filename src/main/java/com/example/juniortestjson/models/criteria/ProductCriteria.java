package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ProductCriteria implements Criteria {
    private String productName;

    private int minTimes;

    @Override
    public String toString() {
        return productName + ", " + String.valueOf(minTimes);
    }
}
