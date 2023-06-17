package com.example.juniortestjson.service;

import com.example.juniortestjson.deserializer.SearchCriteriasDeserializer;
import com.example.juniortestjson.exception.BadRequestException;
import com.example.juniortestjson.models.criteria.Criteria;
import com.example.juniortestjson.models.input.SearchInput;
import com.example.juniortestjson.models.output.ErrorOutput;
import com.example.juniortestjson.models.output.Output;
import com.example.juniortestjson.models.output.search.SearchOutput;
import com.example.juniortestjson.models.output.search.SearchOutputCustomers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedList;

@Slf4j
@Service
public class SearchService {
    private final SearchCriteriasDeserializer deserializer;

    private final DBService dbService;

    @Autowired
    public SearchService(DBService dbService) {
        this.dbService = dbService;
        deserializer = new SearchCriteriasDeserializer();
    }


    public Output search(String jsonCriterias) {

        try {
            SearchInput searchInput = deserializer.deserialize(jsonCriterias);

            SearchOutput searchOutput = new SearchOutput();

            LinkedList<Criteria> criterias = searchInput.getCriterias();
            log.info("searching in database by criterias: {}", criterias.toString());

            for (Criteria criteria : criterias) {
                searchOutput.addResult(searchByCriteria(criteria));
            }

            log.info("search was successfully performed");
            return searchOutput;
        } catch (BadRequestException e) {
            log.info("error: " + e.getMessage());
            return new ErrorOutput(e.getMessage());
        }
    }

    private SearchOutputCustomers searchByCriteria(Criteria criteria) {
        SearchOutputCustomers results = new SearchOutputCustomers();

        results.setCriteria(criteria);
        results.setCustomers(dbService.findByCriteria(criteria));

        return results;
    }
}
