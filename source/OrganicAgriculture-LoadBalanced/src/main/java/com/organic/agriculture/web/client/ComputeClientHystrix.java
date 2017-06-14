package com.organic.agriculture.web.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class ComputeClientHystrix implements ComputeClient {
    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -1;
    }

	@Override
	public ResponseEntity<String> login(@RequestBody String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> authenticate(@RequestBody String body) {
		// TODO Auto-generated method stub
		return null;
	}
}
