package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LastNameCriteria implements Criteria {
    private String lastName;

    @Override
    public String toString() {
        return "lastName: " + lastName;
    }

}
