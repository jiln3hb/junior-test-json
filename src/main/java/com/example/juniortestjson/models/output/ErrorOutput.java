package com.example.juniortestjson.models.output;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorOutput implements Output {

    static final String TYPE = "error";

    private String message;
}
