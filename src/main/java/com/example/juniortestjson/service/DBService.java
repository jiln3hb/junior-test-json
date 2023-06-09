package com.example.juniortestjson.service;

import com.example.juniortestjson.repository.CustomerRepo;
import com.example.juniortestjson.repository.ProductRepo;
import com.example.juniortestjson.repository.PurchaseRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DBService {

    @Autowired
    private final CustomerRepo customerRepo;

    @Autowired
    private final ProductRepo productRepo;

    @Autowired
    private final PurchaseRepo purchaseRepo;


}
