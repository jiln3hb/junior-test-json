package com.example.juniortestjson.controller;

import com.example.juniortestjson.entity.CustomerEntity;
import com.example.juniortestjson.entity.ProductEntity;
import com.example.juniortestjson.entity.PurchaseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class DBController {

    @PostMapping("/addCustomer")
    CustomerEntity addCustomer() {
        return null;
    }

    @PostMapping("/addProduct")
    ProductEntity addProduct() {
        return null;
    }

    @PostMapping("/addPurchase")
    PurchaseEntity addPurchase() {
        return null;
    }
}
