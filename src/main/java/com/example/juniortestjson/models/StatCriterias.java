package com.example.juniortestjson.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class StatCriterias {

    private LocalDate startDate;

    private LocalDate endDate;

    @Override
    public String toString() {
        return "startDate: " + startDate + " endDate: " + endDate;
    }
}
