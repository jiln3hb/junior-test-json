package com.example.juniortestjson.service;

import com.example.juniortestjson.deserializer.SearchCriteriasDeserializer;
import com.example.juniortestjson.entity.CustomerEntity;
import com.example.juniortestjson.models.SearchCriterias;
import com.example.juniortestjson.models.SearchOutput;
import com.example.juniortestjson.models.SearchOutputCustomers;
import com.example.juniortestjson.serializer.SearchOutputSerializer;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
public class SearchService {
    private final SearchCriteriasDeserializer deserializer = new SearchCriteriasDeserializer();

    private final SearchOutputSerializer serializer = new SearchOutputSerializer();

    private final DBService dbService;

    @Autowired
    public SearchService(DBService dbService) {
        this.dbService = dbService;
    }


    public SearchOutput search(String jsonCriterias) {
        SearchCriterias searchCriterias = deserializer.deserialize(jsonCriterias);
        log.info("(search) input json was successfully deserialized");

        SearchOutputCustomers resultByLastName = searchByLastName(searchCriterias.getLastName());
        SearchOutputCustomers resultByProductCriteria = searchByProductCriteria(searchCriterias.getProductCriteria());

        SearchOutput searchOutput = new SearchOutput(new SearchOutputCustomers[]{resultByLastName});


        return searchOutput;
    }

    private SearchOutputCustomers searchByLastName(String lastName) { //TODO сделать чтобы id не выводило
        SearchOutputCustomers resultByLastName = new SearchOutputCustomers();
        resultByLastName.setCriteria(Map.of("lastName", lastName));

        List<CustomerEntity> customersByLastName = dbService.findByLastName(lastName);
        resultByLastName.setCustomers(customersByLastName);

        return resultByLastName;
    }

    private SearchOutputCustomers searchByProductCriteria(Map<String, Object> productCriteria) {
        SearchOutputCustomers resultByProductCriteria = new SearchOutputCustomers();
        resultByProductCriteria.setCriteria(productCriteria);

        List<CustomerEntity> customersByProductCriteria = dbService.findByProductName(productCriteria.get("productName").toString());
        resultByProductCriteria.setCustomers(customersByProductCriteria);

        return resultByProductCriteria;
    }
}
