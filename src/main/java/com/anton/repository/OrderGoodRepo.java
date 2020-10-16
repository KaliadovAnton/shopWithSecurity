package com.anton.repository;

import com.anton.model.OrderGood;
import org.springframework.data.repository.CrudRepository;

public interface OrderGoodRepo extends CrudRepository<OrderGood, Long> {
}
