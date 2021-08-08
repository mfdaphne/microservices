package com.shopping.subscription.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.subscription.dto.SubscriptionDTO;
import com.shopping.subscription.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	private SubscriptionService service;

	public SubscriptionController(SubscriptionService service) {
		this.service = service;
	}

	@PostMapping("/save")
	public ResponseEntity<?> createNewSubscription(@RequestBody SubscriptionDTO dto) {
		service.saveSubscription(dto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<SubscriptionDTO> getSubscription(@PathVariable("id") long id) {
		Optional<SubscriptionDTO> dto = service.getSubscriptionById(id);
		return dto.isPresent() ? ResponseEntity.ok(dto.get()) : ResponseEntity.notFound().build();

	}

	@GetMapping("/details")
	public ResponseEntity<SubscriptionDTO> getSubscriptionByName(@RequestParam("name") String subsName) {
		Optional<SubscriptionDTO> dto = service.getSubscriptionByName(subsName);
		return dto.isPresent() ? ResponseEntity.ok(dto.get()) : ResponseEntity.notFound().build();

	}

}
