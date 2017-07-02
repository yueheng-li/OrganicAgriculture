package com.organic.agriculture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.organic.agriculture.beans.Product;

@Service
public class IndexService {

    @Autowired
    private RestTemplate restTemplate;
    

    public List<Product> getProducts() {
        return restTemplate.getForObject("http://localhost:3222/products", List.class);
    }
}
