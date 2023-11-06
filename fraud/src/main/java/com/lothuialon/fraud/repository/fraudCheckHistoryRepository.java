package com.lothuialon.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothuialon.fraud.entity.fraudCheckHistory;

public interface fraudCheckHistoryRepository extends JpaRepository<fraudCheckHistory, Integer>{
    
}
