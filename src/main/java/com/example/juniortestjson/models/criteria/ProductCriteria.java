package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductCriteria implements Criteria {
    private String productName;

    private int minTimes;

    @Override
    public String toString() {
        return "productName: " + productName + ", minTimes: " + String.valueOf(minTimes);
    }
}
