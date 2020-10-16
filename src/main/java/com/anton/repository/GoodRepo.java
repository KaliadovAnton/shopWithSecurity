package com.anton.repository;

import com.anton.model.Good;
import org.springframework.data.repository.CrudRepository;

public interface GoodRepo extends CrudRepository<Good, Long> {
}
