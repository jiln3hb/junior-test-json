package com.example.juniortestjson.models.input;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class StatInput {

    private LocalDate startDate;

    private LocalDate endDate;

    @Override
    public String toString() {
        return "startDate: " + startDate + " endDate: " + endDate;
    }
}
