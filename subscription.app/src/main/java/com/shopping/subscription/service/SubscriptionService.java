package com.shopping.subscription.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shopping.subscription.dto.SubscriptionDTO;
import com.shopping.subscription.entity.SubscriptionEntity;
import com.shopping.subscription.repository.SubscriptionRepository;

@Service
public class SubscriptionService {

	private SubscriptionRepository repository;

	private SubscriptionConverter converter;

	public SubscriptionService(SubscriptionRepository repository, SubscriptionConverter converter) {
		this.repository = repository;
		this.converter = converter;
	}

	public void saveSubscription(SubscriptionDTO dto) {
		repository.save(converter.convertToEntity(dto));

	}

	public Optional<SubscriptionDTO> getSubscriptionById(long id) {
		Optional<SubscriptionEntity> entity = repository.findById(id);
		if (entity.isPresent()) {
			return Optional.of(converter.convertToDTO(entity.get()));
		}

		return Optional.empty();
	}

	public Optional<SubscriptionDTO> getSubscriptionByName(String subscriptionName) {
		Optional<SubscriptionEntity> entity = repository.findBySubscriptionName(subscriptionName);
		if (entity.isPresent()) {
			return Optional.of(converter.convertToDTO(entity.get()));
		}

		return Optional.empty();
	}

}
