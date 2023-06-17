package com.example.juniortestjson.deserializer;

import com.example.juniortestjson.exception.BadRequestException;
import com.example.juniortestjson.models.input.StatInput;
import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

import static com.google.gson.JsonParser.parseString;

@Slf4j
public class StatCriteriasDeserializer {

    public StatInput deserialize(String json) {
        JsonObject input = parseString(json).getAsJsonObject();

        StatInput statInput = new StatInput();

        LocalDate startDate = getDate("startDate", input), endDate = getDate("endDate", input);
        int totalDays = getTotalDays(startDate, endDate);

        statInput.setStartDate(getDate("startDate", input));
        statInput.setEndDate(getDate("endDate", input));
        statInput.setTotalDays(totalDays);

        log.info("stat: input json was successfully deserialized");
        return statInput;
    }

    private LocalDate getDate(String key, JsonObject input) {
        try {
            return LocalDate.parse(input.get(key).getAsString());
        } catch (DateTimeParseException e) {
            throw new BadRequestException(key.equals("startDate") ? "Начальная дата невалидна" : "Конечная дата невалидна");
        }
    }

    private int getTotalDays(LocalDate startDate, LocalDate endDate) {
        int totalDays = (int) ChronoUnit.DAYS.between(startDate, endDate);

        if (totalDays < 0) {
            throw new BadRequestException("Начальная дата позже конечной даты");
        }

        return totalDays + 1;
    }
}
