package com.anton.service;

import com.anton.model.Order;
import com.anton.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.StreamSupport;

@Service
public class OrderService {

    @Autowired
    private final OrderRepo orderRepo;
    @Autowired
    private UserService userService;

    @Autowired
    public OrderService(OrderRepo userRepo){
        this.orderRepo = userRepo;
    }

    public Order getOrderByUserName(String name){
        return StreamSupport.stream(orderRepo.findAll().spliterator(),false).filter(order -> order.getUserID()==userService.getIdByName(name)).findAny().get();
    }

    public void save(Order order) {
        orderRepo.save(order);
    }
}
