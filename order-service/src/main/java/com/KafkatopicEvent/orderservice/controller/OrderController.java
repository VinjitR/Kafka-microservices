package com.KafkatopicEvent.orderservice.controller;

import com.KafkatopicEvent.basedomains.dto.Order;
import com.KafkatopicEvent.basedomains.dto.OrderEvent;
import com.KafkatopicEvent.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){

        order.setOrderID(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is pending");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "Order placed Successfully.";
    }

}
