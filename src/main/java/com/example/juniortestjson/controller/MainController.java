package com.example.juniortestjson.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class MainController {

    @GetMapping("/search")
    JSONPObject search() {
        return null;
    }

    @GetMapping("/stat")
    JSONPObject stat() {
        return null;
    }
}