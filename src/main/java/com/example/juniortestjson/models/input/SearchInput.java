package com.example.juniortestjson.models.input;

import com.example.juniortestjson.models.criteria.Criteria;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Getter
@Setter
public class SearchInput {

    private LinkedList<Criteria> criterias;

    public SearchInput() {
        criterias = new LinkedList<>();
    }

    @Override
    public String toString() {
        return criterias.toString();
    }
}
