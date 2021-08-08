package com.shopping.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

	@GetMapping("/userServiceFallback")
	public String userServiceFallback() {
		return "User Service is taking longer than expected ! Please try again later";
	}

	@GetMapping("/subscriptionServiceFallback")
	public String subscriptionServiceFallback() {
		return "Subscription Service is taking longer than expected ! Please try again later";
	}
}
