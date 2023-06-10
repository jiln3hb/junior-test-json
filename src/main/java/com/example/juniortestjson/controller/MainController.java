package com.example.juniortestjson.controller;

import com.example.juniortestjson.models.SearchOutput;
import com.example.juniortestjson.service.SearchService;
import com.example.juniortestjson.service.StatService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class MainController {
    final SearchService searchService;
    final StatService statService;

    @Autowired
    public MainController(SearchService searchService, StatService statService) {
        this.searchService = searchService;
        this.statService = statService;
    }

    @GetMapping(value = "/search")
    SearchOutput search(@RequestBody String jsonCriterias) {
        log.info("get mapping search");

        return searchService.search(jsonCriterias);
    }

    @GetMapping("/stat")
    String stat(@RequestBody String jsonCriterias) {
        log.info("get mapping stat");

        return statService.stat(jsonCriterias);
    }
}