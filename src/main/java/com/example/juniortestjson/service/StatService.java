package com.example.juniortestjson.service;

import com.example.juniortestjson.deserializer.StatCriteriasDeserializer;
import com.example.juniortestjson.dto.ProductDTO;
import com.example.juniortestjson.exception.BadRequestException;
import com.example.juniortestjson.models.input.StatInput;
import com.example.juniortestjson.models.output.stat.StatOutput;
import com.example.juniortestjson.repository.CustomerRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Slf4j
@Service
public class StatService {

    private final StatCriteriasDeserializer deserializer;

    private final DBService dbService;

    private final CustomerRepo customerRepo;

    @Autowired
    public StatService(DBService dbService, CustomerRepo customerRepo) {
        this.dbService = dbService;
        this.customerRepo = customerRepo;
        deserializer = new StatCriteriasDeserializer();
    }

    public List<ProductDTO> stat(String jsonCriterias) {
        try {
            StatInput statInput = deserializer.deserialize(jsonCriterias);
            log.info("(stat) input json was successfully deserialized");

            StatOutput statOutput = new StatOutput();

            try {
                statOutput.setTotalDays((int) ChronoUnit.DAYS.between(statInput.getStartDate(), statInput.getEndDate()));
            }catch (RuntimeException e) {
                e.printStackTrace();
            }

            return dbService.findStat(statInput.getStartDate(), statInput.getEndDate());

        } catch (RuntimeException e) {
            //return new ErrorOutput(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
