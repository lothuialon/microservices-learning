package com.lothuialon.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothuialon.user.entity.user;

public interface userRepository extends JpaRepository<user, Integer>{
    
}
