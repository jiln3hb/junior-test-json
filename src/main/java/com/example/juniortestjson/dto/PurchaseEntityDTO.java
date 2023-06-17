package com.example.juniortestjson.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PurchaseEntityDTO {

    private Long customerId;

    private List<Long> productsIds;
}
