package com.example.juniortestjson.models;

import com.example.juniortestjson.entity.CustomerEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class SearchOutputCustomers {

    private Map<String, Object> criteria;

    private List<CustomerEntity> results;

    public void setCriteria(Map<String, Object> criteria) {
        this.criteria = criteria;
    }

    public void setCustomers(List<CustomerEntity> result) {
        this.results = result;
    }
}
