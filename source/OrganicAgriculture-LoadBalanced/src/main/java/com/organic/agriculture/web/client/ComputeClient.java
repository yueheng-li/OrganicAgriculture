package com.organic.agriculture.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

	@RequestMapping(method = RequestMethod.GET, value = "/add")
	Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

	/**
	 * 登录
	 */
	@RequestMapping (value = "/login", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> login(@RequestBody String user);
	

	@RequestMapping (value = "/authenticate", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ResponseEntity<String> authenticate(@RequestBody String body);

}
