package com.shopping.user.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.user.dto.ResponseTemplateDto;
import com.shopping.user.dto.UserDTO;
import com.shopping.user.service.UserService;
import com.shopping.user.service.exception.UserIdNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody UserDTO dto) {
		userService.saveUser(dto);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable("id") long id) throws UserIdNotFoundException {
		return ResponseEntity.ok(userService.getUserById(id));
	}

	@GetMapping("/subscription-status/{id}")
	public ResponseEntity<ResponseTemplateDto> getUserWithSubscription(@PathVariable("id") long id) {
		Optional<ResponseTemplateDto> responseTemplate = userService.getUserWithSubscription(id);

		return responseTemplate.isPresent() ? ResponseEntity.ok(responseTemplate.get())
				: ResponseEntity.notFound().build();
	}
}
