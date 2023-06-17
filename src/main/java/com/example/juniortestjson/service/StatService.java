package com.example.juniortestjson.service;

import com.example.juniortestjson.deserializer.StatCriteriasDeserializer;
import com.example.juniortestjson.exception.BadRequestException;
import com.example.juniortestjson.models.input.StatInput;
import com.example.juniortestjson.models.output.ErrorOutput;
import com.example.juniortestjson.models.output.Output;
import com.example.juniortestjson.models.output.stat.StatOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Slf4j
@Service
public class StatService {

    private final StatCriteriasDeserializer deserializer;

    private final DBService dbService;

    @Autowired
    public StatService(DBService dbService) {
        this.dbService = dbService;
        deserializer = new StatCriteriasDeserializer();
    }

    public Output stat(String jsonCriterias) {
        try {
            StatInput statInput = deserializer.deserialize(jsonCriterias);

            LocalDate startDate = statInput.getStartDate(), endDate = statInput.getEndDate();

            int totalDays = statInput.getTotalDays();

            log.info("searching stat in database between {} and {}, with total days is {}", startDate, endDate, totalDays);

            StatOutput statOutput = new StatOutput();

            statOutput.setTotalDays(totalDays);
            statOutput.setCustomers(dbService.findStatByStartDateAndEndDate(startDate, endDate));

            log.info("searching stat was successfully performed");
            return statOutput;
        } catch (BadRequestException e) {
            log.info("error: " + e.getMessage());
            return new ErrorOutput(e.getMessage());
        }
    }
}
