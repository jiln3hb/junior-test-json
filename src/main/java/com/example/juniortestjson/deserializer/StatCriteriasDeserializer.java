package com.example.juniortestjson.deserializer;

import com.example.juniortestjson.models.input.StatInput;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static com.google.gson.JsonParser.parseString;

//нужно ли создавать интерфейс deserializer?
@Slf4j
public class StatCriteriasDeserializer {

    public StatInput deserialize(String json) {
        JsonObject input = parseString(json).getAsJsonObject();

        StatInput statInput = new StatInput();

        statInput.setStartDate(getDate("startDate", input));
        statInput.setEndDate(getDate("endDate", input));

        return statInput;
    }

    private LocalDate getDate(String key, JsonObject input) {
        try {
            return LocalDate.parse(input.get(key).getAsString());
        } catch (DateTimeParseException e) {
            throw new RuntimeException(key.equals("startDate") ? "Начальная дата невалидна" : "Конечная дата невалидна");
        }
    }
}
