package com.example.juniortestjson.models.output.stat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

@Getter
@Setter
public class StatOutputCustomer {

    private String name;

    private LinkedList<Map<String, Object>> purchases;

    private int totalExpenses;

    public StatOutputCustomer() {
        purchases = new LinkedList<>();
    }

    public void addPurchase(Map<String, Object> purchase) {
        purchases.add(purchase);
    }
}
