package com.example.juniortestjson.models.output.stat;

import com.example.juniortestjson.models.output.Output;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;

@Getter
@Setter
public class StatOutput implements Output {

    static final String TYPE = "stat";

    private int totalDays;

    private LinkedList<StatOutputCustomer> customers;

    public StatOutput() {
        customers = new LinkedList<>();
    }

    public void addCustomer(StatOutputCustomer customer) {
        customers.add(customer);
    }
}
