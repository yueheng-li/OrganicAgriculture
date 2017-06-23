package com.organic.agriculture.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.organic.agriculture.web.filter.AccessFilter;

@ComponentScan(basePackages = {"com.organic.agriculture.web"})
@SpringBootApplication
@EnableFeignClients
@EnableZuulProxy
@EnableDiscoveryClient
public class LoadBalancedApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(LoadBalancedApplication.class, args);
	}

	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	
	
}