package com.example.juniortestjson.models.output.stat;

import com.example.juniortestjson.models.output.Output;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StatOutput implements Output {

    static final String TYPE = "stat";

    private int totalDays;

    private List<StatOutputCustomer> customers;
}
