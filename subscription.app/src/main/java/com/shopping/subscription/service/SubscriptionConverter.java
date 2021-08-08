package com.shopping.subscription.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shopping.subscription.dto.SubscriptionDTO;
import com.shopping.subscription.entity.SubscriptionEntity;

@Service
public class SubscriptionConverter {

	private ModelMapper mapper;

	public SubscriptionConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public SubscriptionDTO convertToDTO(SubscriptionEntity entity) {
		return mapper.map(entity, SubscriptionDTO.class);

	}

	public SubscriptionEntity convertToEntity(SubscriptionDTO dto) {
		return mapper.map(dto, SubscriptionEntity.class);
	}
}
