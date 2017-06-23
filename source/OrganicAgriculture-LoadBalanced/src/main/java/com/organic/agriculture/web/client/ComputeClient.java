package com.organic.agriculture.web.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "compute-service", fallback = ComputeClientHystrix.class)
public interface ComputeClient {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.GET, value = "/add")
	Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

//	/**
//	 * 登录
//	 */
//	@RequestMapping (value = "/login", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
//	public ResponseEntity<String> login(@RequestBody String user);
//	
//
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
//	@RequestMapping (value = "/authenticate", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
//	public ResponseEntity<String> authenticate(@RequestBody String body);

}
