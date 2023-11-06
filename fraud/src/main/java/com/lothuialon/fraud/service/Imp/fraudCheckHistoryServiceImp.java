package com.lothuialon.fraud.service.Imp;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lothuialon.clients.fraud.fraudDTO;
import com.lothuialon.fraud.entity.fraudCheckHistory;
import com.lothuialon.fraud.repository.fraudCheckHistoryRepository;
import com.lothuialon.fraud.service.fraudCheckHistoryService;

@Service
public class fraudCheckHistoryServiceImp implements fraudCheckHistoryService{

    private fraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Autowired
    public fraudCheckHistoryServiceImp(fraudCheckHistoryRepository fraudCheckHistoryRepository) {
        this.fraudCheckHistoryRepository = fraudCheckHistoryRepository;
    }



    @Override
    public fraudDTO userIsFraud(Integer userId) {
        fraudCheckHistory checkHistory = fraudCheckHistoryRepository.save(
            
            fraudCheckHistory.builder()
            .userId(userId)
            .createdAt(LocalDateTime.now())
            .isFraud(false)
            .build());

        return fraudDTO.builder()
        .userId(userId)
        .createdAt(LocalDateTime.now())
        .isFraud(false)            
        .build();

    }
    
}
