package com.anton.service;

import com.anton.repository.OrderGoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderGoodService {

    private final OrderGoodRepo orderGoodRepo;

    @Autowired
    public OrderGoodService(OrderGoodRepo orderGoodRepo) {

        this.orderGoodRepo = orderGoodRepo;
    }

    public void save(int orderID, int productID) {
    }

    public Object findAll() {
        return orderGoodRepo.findAll();
    }
}
