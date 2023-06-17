package com.example.juniortestjson.deserializer;

import com.example.juniortestjson.exception.BadRequestException;
import com.example.juniortestjson.models.criteria.*;
import com.example.juniortestjson.models.input.SearchInput;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.google.gson.JsonParser.parseString;

@Slf4j
@NoArgsConstructor
public class SearchCriteriasDeserializer {
    static final String NAME_REGEX = "^[a-zA-Zа-яА-Я]{1,30}$";

    static final String PRODUCT_NAME_REGEX = "^[a-zA-Zа-яА-Я ]{1,255}$";

    public SearchInput deserialize(String json) {
        JsonArray input = parseString(json).getAsJsonObject().getAsJsonArray("criterias");

        SearchInput searchInput = new SearchInput();

        searchInput.setCriterias(getCriterias(input));

        log.info("search: input json was successfully deserialized");
        return searchInput;
    }

    private LinkedList<Criteria> getCriterias(JsonArray input) {
        LinkedList<Criteria> criterias = new LinkedList<>();

        for (CriteriaTypes type: CriteriaTypes.values()) {
            if (hasValue(input, type)) {
                for (Integer i: whereIsValue(input, type)) {
                    JsonObject object = input.get(i).getAsJsonObject();

                    switch (type) {
                        case LAST_NAME -> criterias.add(getLastNameCriteria(object));
                        case PRODUCT -> criterias.add(getProductCriteria(object));
                        case PRICE -> criterias.add(getPriceCriteria(object));
                        case BAD_CUSTOMERS -> criterias.add(getBadCustomersCriteria(object));
                        default -> throw new BadRequestException("Критерии невалидны");
                    }
                }
            }
        }

        return criterias;
    }

    private LastNameCriteria getLastNameCriteria(JsonObject object) {
        String lastName = object.get("lastName").getAsString();

        if (lastName.matches(NAME_REGEX)) {
            return new LastNameCriteria(lastName);
        } else {
            throw new BadRequestException("Фамилия невалидна");
        }
    }

    private ProductCriteria getProductCriteria(JsonObject object) {
        String productName = object.get("productName").getAsString();
        String minTimes = object.get("minTimes").getAsString();

        if (productName.matches(PRODUCT_NAME_REGEX)) {
            if (isParsable(minTimes)) {
                return new ProductCriteria(productName, Integer.parseInt(minTimes));
            } else {
                throw new BadRequestException("Количество раз, которое покупатель покупал указанный товар, невалидно");
            }
        } else {
            throw new BadRequestException("Название товара невалидно");
        }
    }

    private PriceCriteria getPriceCriteria(JsonObject object) {
        String minExpenses = object.get("minExpenses").getAsString();
        String maxExpenses = object.get("maxExpenses").getAsString();

        if (isParsable(minExpenses)) {
            if (isParsable(maxExpenses)) {
                return new PriceCriteria(Integer.parseInt(minExpenses), Integer.parseInt(maxExpenses));
            } else {
                throw new BadRequestException("Минимальная стоимость всех покупок невалидна");
            }
        } else {
            throw new BadRequestException("Максимальная стоимость всех покупок невалидна");
        }
    }

    private BadCustomersCriteria getBadCustomersCriteria(JsonObject object) {
        String badCustomers = object.get("badCustomers").getAsString();

        if (isParsable(badCustomers)) {
            return new BadCustomersCriteria(Integer.parseInt(badCustomers));
        } else {
            throw new BadRequestException("Число пассивных покупателей невалидно");
        }
    }

    private boolean hasValue(JsonArray jsonArray, CriteriaTypes type) {
        boolean res;

        Set<String> keySet = type.getKeySet();

        Stream<JsonElement> stream = StreamSupport.stream(jsonArray.spliterator(), true);


        if (keySet.size() == 1) {
            res = stream.anyMatch(j -> j.getAsJsonObject().has(keySet.iterator().next()));
        } else {
            res = stream.anyMatch(j -> j.getAsJsonObject().has(keySet.iterator().next()) && j.getAsJsonObject().has(keySet.iterator().next()));
        }

        return res;
    }

    private ArrayList<Integer> whereIsValue(JsonArray jsonArray, CriteriaTypes type) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<String> keySet = type.getKeySet();

        if (keySet.size() == 1) {
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject object = jsonArray.get(i).getAsJsonObject();
                if (object.has(keySet.iterator().next())) {
                    res.add(i);
                }
            }
        } else {
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject object = jsonArray.get(i).getAsJsonObject();
                if (object.has(keySet.iterator().next()) && object.has(keySet.iterator().next())) {
                    res.add(i);
                }
            }
        }

        return res;
    }

    private boolean isParsable(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
