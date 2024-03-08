package com.KafkatopicEvent.basedomains.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String orderID;
    private String name;
    private int qty;
    private double price;
}
