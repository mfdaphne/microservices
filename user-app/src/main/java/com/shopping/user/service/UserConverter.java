package com.shopping.user.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.shopping.user.dto.UserDTO;
import com.shopping.user.entity.UserEntity;

@Service
public class UserConverter {

	private ModelMapper mapper;

	public UserConverter(ModelMapper mapper) {
		this.mapper = mapper;
	}

	public UserDTO toUserDto(UserEntity entity) {
		return mapper.map(entity, UserDTO.class);

	}

	public UserEntity toUserEntity(UserDTO dto) {
		return mapper.map(dto, UserEntity.class);
	}
}
