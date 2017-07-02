package com.organic.agriculture.web.controller;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organic.agriculture.web.service.ProductService;

@RestController
public class ProductController {
	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private DiscoveryClient client;
	
	@Autowired
	private ProductService service;

    @RequestMapping(path = "/products", method = RequestMethod.GET, name = "getProductList")
	public ResponseEntity getProducts() {
		return Optional.ofNullable(service.selectAllProdouct())
        .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
}