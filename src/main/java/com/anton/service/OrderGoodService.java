package com.anton.service;

import com.anton.repository.OrderGoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderGoodService {

    private final OrderGoodRepository orderGoodRepository;

    @Autowired
    public OrderGoodService(OrderGoodRepository orderGoodRepository) {
        this.orderGoodRepository = orderGoodRepository;
    }

    public void save(int orderID, int productID) {
    //    orderGoodRepository.save(orderID,productID);
    }
}
