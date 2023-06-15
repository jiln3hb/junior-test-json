package com.example.juniortestjson.controller;

import com.example.juniortestjson.dto.ProductDTO;
import com.example.juniortestjson.models.output.Output;
import com.example.juniortestjson.service.SearchService;
import com.example.juniortestjson.service.StatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@Slf4j
public class MainController {
    private final SearchService searchService;
    private final StatService statService;

    @Autowired
    public MainController(SearchService searchService, StatService statService) {
        this.searchService = searchService;
        this.statService = statService;
    }

    @GetMapping(value = "/search")
    Output search(@RequestBody String jsonCriterias) {
        log.info("get mapping search");

        return searchService.search(jsonCriterias);
    }

    @GetMapping("/stat")
    List<ProductDTO> stat(@RequestBody String jsonCriterias) {
        log.info("get mapping stat");

        return statService.stat(jsonCriterias);
    }
}