package com.example.juniortestjson.models.output.search;

import com.example.juniortestjson.dto.CustomerEntityDTO;
import com.example.juniortestjson.models.criteria.Criteria;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
public class SearchOutputCustomers {

    private Criteria criteria;

    private List<CustomerEntityDTO> results;

    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    public void setCustomers(List<CustomerEntityDTO> result) {
        this.results = result;
    }
}
