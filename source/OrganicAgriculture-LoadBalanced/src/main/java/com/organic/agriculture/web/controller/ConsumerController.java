package com.organic.agriculture.web.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.organic.agriculture.web.client.ComputeClient;

@RestController
public class ConsumerController {
	private final Logger logger = Logger.getLogger(getClass());
	// @Autowired
	// RestTemplate restTemplate;
	//
	// @RequestMapping(value = "/add", method = RequestMethod.GET)
	// public String add() {
	// return restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20",
	// String.class).getBody();
	// }

	@Autowired
	ComputeClient computeClient;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public Integer add() {
		return computeClient.add(10, 20);
	}

}