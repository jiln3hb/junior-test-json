package com.example.juniortestjson.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class SearchOutput {

    private final String type = "search";

    private SearchOutputCustomers[] results;
}
