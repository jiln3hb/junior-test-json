package com.example.juniortestjson.service;

import com.example.juniortestjson.dto.CustomerEntityDTO;
import com.example.juniortestjson.dto.ProductDTO;
import com.example.juniortestjson.dto.PurchaseEntityDTO;
import com.example.juniortestjson.entity.CustomerEntity;
import com.example.juniortestjson.entity.ProductEntity;
import com.example.juniortestjson.entity.PurchaseEntity;
import com.example.juniortestjson.exception.NotFoundException;
import com.example.juniortestjson.models.criteria.*;
import com.example.juniortestjson.repository.CustomerRepo;
import com.example.juniortestjson.repository.ProductRepo;
import com.example.juniortestjson.repository.PurchaseRepo;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

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

    public void save(PurchaseEntityDTO purchaseEntityDTO) {
        Optional<CustomerEntity> customer = customerRepo.findById(purchaseEntityDTO.getCustomerId());

        if (customer.isEmpty()) {
            throw new NotFoundException("Покупатель с таким id не найден");
        }

        Set<ProductEntity> products = new HashSet<>();

        for(Long productId : purchaseEntityDTO.getProductsIds()) {
            Optional<ProductEntity> product = productRepo.findById(productId);

            if (product.isEmpty()) {
                throw new NotFoundException("Товар с таким id не найден");
            } else {
                products.add(product.get());
            }
        }

        PurchaseEntity purchase = new PurchaseEntity();

        purchase.setCustomer(customer.get());
        purchase.setProducts(products);
        purchase.setPurchaseDate(LocalDate.now());

        purchaseRepo.save(purchase);
    }

    public List<CustomerEntityDTO> findByCriteria(Criteria criteria) {
        if (criteria instanceof LastNameCriteria lastNameCriteria) {
            return customerRepo.findByLastName(lastNameCriteria.getLastName());
        } else if (criteria instanceof ProductCriteria productCriteria) {
            return purchaseRepo.findCustomersByProductNameAndNumberOfPurchases(productCriteria.getProductName(), productCriteria.getMinTimes());
        } else if (criteria instanceof PriceCriteria priceCriteria) {
            return purchaseRepo.findCustomersByMinAndMaxExpenses(priceCriteria.getMinExpenses(), priceCriteria.getMaxExpenses());
        } else if (criteria instanceof BadCustomersCriteria badCustomersCriteria) {
            return purchaseRepo.findBadCustomers(badCustomersCriteria.getBadCustomers());
        }
        return null;
    }

    public List<Long> findCustomersWithPurchasesInPeriod(LocalDate startDate, LocalDate endDate) {
        return purchaseRepo.findCustomerIdsWithPurchasesInPeriod(startDate, endDate);
    }

    public List<ProductDTO> findStat(LocalDate startDate, LocalDate endDate) {
        return purchaseRepo.findStat(startDate, endDate);
    }
}
