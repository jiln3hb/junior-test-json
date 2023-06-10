package com.example.juniortestjson.service;

import com.example.juniortestjson.deserializer.StatCriteriasDeserializer;
import com.example.juniortestjson.models.StatCriterias;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StatService {

    final StatCriteriasDeserializer deserializer = new StatCriteriasDeserializer();

    public String stat(String jsonCriterias) {
        StatCriterias criterias = deserializer.deserialize(jsonCriterias);
        log.info("(stat) input json was successfully deserialized");

        return criterias.toString();
    }
}
