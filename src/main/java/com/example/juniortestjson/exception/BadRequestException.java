package com.example.juniortestjson.exception;

public class BadRequestException extends RuntimeException{

    public BadRequestException(String msg) {
        super(msg);
    }
}
