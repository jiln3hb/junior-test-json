package com.example.juniortestjson.deserializer;

import com.example.juniortestjson.exception.BadRequestException;
import com.example.juniortestjson.models.StatCriterias;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//нужно ли создавать интерфейс deserializer?
@Slf4j
public class StatCriteriasDeserializer {

    public StatCriterias deserialize(String json) {
        JSONObject input = new JSONObject(json);

        StatCriterias statCriterias = new StatCriterias();
        statCriterias.setStartDate(getStartDate(input));
        statCriterias.setEndDate(getEndDate(input));

        return statCriterias;
    }

    private LocalDate getStartDate(JSONObject input) {
        try {
            return LocalDate.parse(input.get("startDate").toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            log.info("startDate is not valid");
            throw new BadRequestException("startDate is not valid");
        }
    }

    private LocalDate getEndDate(JSONObject input) {
        try {
            return LocalDate.parse(input.get("endDate").toString(), DateTimeFormatter.ISO_LOCAL_DATE);
        } catch (Exception e) {
            log.info("endDate is not valid");
            throw new BadRequestException("endDate is not valid");
        }
    }
}
