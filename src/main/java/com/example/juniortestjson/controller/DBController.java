package com.example.juniortestjson.controller;

import com.example.juniortestjson.dto.PurchaseEntityDTO;
import com.example.juniortestjson.entity.CustomerEntity;
import com.example.juniortestjson.entity.ProductEntity;
import com.example.juniortestjson.service.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class DBController {
    private final DBService dbService;

    @Autowired
    public DBController(DBService dbService) {
        this.dbService = dbService;
    }

    @PostMapping("/addCustomer")
    void addCustomer(@RequestBody CustomerEntity customerEntity) {
        dbService.save(customerEntity);
    }

    @PostMapping("/addProduct")
    void addProduct(@RequestBody ProductEntity productEntity) {
        dbService.save(productEntity);
    }

    @PostMapping("/addPurchase")
    void addPurchase(@RequestBody PurchaseEntityDTO purchaseEntityDTO) {
        dbService.save(purchaseEntityDTO);
    }
}
