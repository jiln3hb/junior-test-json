package com.example.juniortestjson.service;

import com.example.juniortestjson.entity.CustomerEntity;
import com.example.juniortestjson.entity.ProductEntity;
import com.example.juniortestjson.entity.PurchaseEntity;
import com.example.juniortestjson.repository.CustomerRepo;
import com.example.juniortestjson.repository.ProductRepo;
import com.example.juniortestjson.repository.PurchaseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private final CustomerRepo customerRepo;

    private final ProductRepo productRepo;

    private final PurchaseRepo purchaseRepo;

    @Autowired
    public DBService(CustomerRepo customerRepo, ProductRepo productRepo, PurchaseRepo purchaseRepo) {
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.purchaseRepo = purchaseRepo;
    }

    public void save(CustomerEntity customerEntity) {
        customerRepo.save(customerEntity);
    }

    public void save(ProductEntity productEntity) {
        productRepo.save(productEntity);
    }

    public void save(PurchaseEntity purchaseEntity) {
        purchaseRepo.save(purchaseEntity);
    }

    public List<CustomerEntity> findByLastName(String lastName) {
        return customerRepo.findByLastName(lastName);
    }

    //public List<CustomerEntity> findByProductName(String productName) {}

}
