package com.organic.agriculture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.organic.agriculture.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class LoadBalancedApplication {
//	@Bean
//	@LoadBalanced
//	RestTemplate restTemplate() {
//		return new RestTemplate();
//	}
	public static void main(String[] args) {
		SpringApplication.run(LoadBalancedApplication.class, args);
	}
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}