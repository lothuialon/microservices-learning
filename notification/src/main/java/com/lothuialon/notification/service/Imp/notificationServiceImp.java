package com.lothuialon.notification.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lothuialon.notification.entity.notification;
import com.lothuialon.clients.notification.notificationDTO;
import com.lothuialon.notification.repository.notificationRepository;
import com.lothuialon.notification.service.notificationService;

@Service
public class notificationServiceImp implements notificationService{

    private final notificationRepository notificationRepository;

    @Autowired
    public notificationServiceImp(notificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }


    @Override
    public void send(notificationDTO notificationDTO) {

        
        notificationRepository.save(
        notification.builder()
        .toCustomerId(notificationDTO.getToCustomerId())
        .toCustomerEmail(notificationDTO.getToCustomerEmail())
        .sender(notificationDTO.getSender())
        .sentAt(notificationDTO.getSentAt())
        .message(notificationDTO.getMessage())
        .build()

        );

    }
    
}
