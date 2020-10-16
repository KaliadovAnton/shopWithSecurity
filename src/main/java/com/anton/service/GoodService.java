package com.anton.service;

import com.anton.model.Good;
import com.anton.repository.GoodRepo;
import com.anton.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class GoodService {

    private final GoodRepository goodRepository;
    @Autowired
    GoodRepo goodRepo;

    @Autowired
    public GoodService(GoodRepository goodRepository) {
        this.goodRepository = goodRepository;
    }

    public List<Good> getAll() {
        return (List<Good>) goodRepo.findAll();
    }

    public Good getProductByName(String productName) {
        return StreamSupport.stream(goodRepo.findAll().spliterator(),false).filter(good -> good.getName().equals(productName)).findFirst().get();
    }
}
