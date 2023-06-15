package com.example.juniortestjson.models.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LastNameCriteria implements Criteria {
    private String lastName;

    @Override
    public String toString() {
        return lastName;
    }

}
