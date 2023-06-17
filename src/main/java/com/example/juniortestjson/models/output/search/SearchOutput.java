package com.example.juniortestjson.models.output.search;

import com.example.juniortestjson.models.output.Output;
import lombok.Getter;

import java.util.LinkedList;

@Getter
public class SearchOutput implements Output {

    static final String TYPE = "search";

    private LinkedList<SearchOutputCustomers> results;

    public SearchOutput() {
        results = new LinkedList<>();
    }

    public void addResult(SearchOutputCustomers result) {
        results.add(result);
    }
}
