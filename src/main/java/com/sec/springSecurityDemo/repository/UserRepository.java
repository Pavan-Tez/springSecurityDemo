package com.sec.springSecurityDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.springSecurityDemo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>  {
    
    Optional<UserEntity> findByUserName(String userName);
    
}
