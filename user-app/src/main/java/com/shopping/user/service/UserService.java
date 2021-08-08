package com.shopping.user.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shopping.user.dto.ResponseTemplateDto;
import com.shopping.user.dto.SubscriptionDTO;
import com.shopping.user.dto.UserDTO;
import com.shopping.user.entity.UserEntity;
import com.shopping.user.repository.UserRepository;
import com.shopping.user.service.exception.UserIdNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	private UserRepository userRepository;

	private UserConverter converter;

	private RestTemplate restTemplate;

	public UserService(UserRepository userRepository, UserConverter converter, RestTemplate restTemplate) {
		this.userRepository = userRepository;
		this.converter = converter;
		this.restTemplate = restTemplate;
	}

	public void saveUser(UserDTO dto) {
		log.info("Saving User");
		UserEntity userEntity = converter.toUserEntity(dto);

		userRepository.save(userEntity);

	}

	public UserDTO getUserById(long id) throws UserIdNotFoundException {
		Optional<UserEntity> opUserEntity = userRepository.findById(id);
		if (opUserEntity.isPresent()) {
			return converter.toUserDto(opUserEntity.get());
		}
		throw new UserIdNotFoundException(id);
	}

	public Optional<ResponseTemplateDto> getUserWithSubscription(long id) {
		Optional<UserEntity> user = userRepository.findById(id);
		if (user.isPresent()) {
			String userSubscription = user.get().getSubscription();
			SubscriptionDTO subs = restTemplate.getForObject(
					"http://SUBSCRIPTION-APP/subscription/details?name=" + userSubscription, SubscriptionDTO.class);

			ResponseTemplateDto responseTemplateDto = new ResponseTemplateDto();
			responseTemplateDto.setUser(converter.toUserDto(user.get()));
			responseTemplateDto.setSubscription(subs);

			return Optional.of(responseTemplateDto);
		}
		return Optional.empty();
	}
}
