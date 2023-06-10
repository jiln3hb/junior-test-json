package com.example.juniortestjson.deserializer;

import com.example.juniortestjson.exception.BadRequestException;
import com.example.juniortestjson.models.SearchCriterias;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Map;

//нужно ли создавать интерфейс deserializer?
@Slf4j
public class SearchCriteriasDeserializer {

    public SearchCriterias deserialize(String json) {
        JSONArray input = new JSONObject(json).getJSONArray("criterias");

        SearchCriterias searchCriterias = new SearchCriterias();
        searchCriterias.setLastName(getLastName(input));
        searchCriterias.setProductCriteria(getProductInfo(input));
        searchCriterias.setPriceCriteria(getPriceInfo(input));
        searchCriterias.setBadCustomers(getBadCustomers(input));

        return searchCriterias;
    }

    private String getLastName(JSONArray input) {
        Object lastName = input.getJSONObject(0).get("lastName");

        if (lastName instanceof String) {
            return lastName.toString();
        } else {
            log.info("lastName is not valid");
            throw new BadRequestException("lastName is not valid");
        }
    }

    private Map<String, Object> getProductInfo(JSONArray input) {
        JSONObject jsonObject = input.getJSONObject(1);

        Object productName = jsonObject.get("productName");

        if (!(productName instanceof String)) {
            log.info("productName is not valid");
           throw new BadRequestException("productName is not valid");
        }

        Object minTimes = jsonObject.get("minTimes");

        if (!(minTimes instanceof Integer)) {
            log.info("minTimes is not valid");
            throw new BadRequestException("minTimes is not valid");
        }

        return Map.of("productName", productName.toString(), "minTimes", (Integer) minTimes);
    }

    private Map<String, Integer> getPriceInfo(JSONArray input) {
        JSONObject jsonObject = input.getJSONObject(2);

        Object minExpenses = jsonObject.get("minExpenses");

        if (!(minExpenses instanceof Integer)) {
            log.info("minExpenses is not valid");
            throw new BadRequestException("minExpenses is not valid");
        }

        Object maxExpenses = jsonObject.get("maxExpenses");

        if (!(maxExpenses instanceof Integer)) {
            log.info("maxExpenses is not valid");
            throw new BadRequestException("maxExpenses is not valid");
        }

        return Map.of("minExpenses", (Integer) minExpenses, "maxExpenses", (Integer) maxExpenses);
    }

    private Integer getBadCustomers(JSONArray input) {
        Object badCustomers = input.getJSONObject(3).get("badCustomers");

        if (badCustomers instanceof Integer) {
            return (Integer) badCustomers;
        } else {
            log.info("badCustomers is not valid");
            throw new BadRequestException("badCustomers is not valid");
        }
    }
}
