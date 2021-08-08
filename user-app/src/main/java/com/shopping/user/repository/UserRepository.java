package com.shopping.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
