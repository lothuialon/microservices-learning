package com.lothuialon.user.service.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lothuialon.clients.fraud.fraudClient;
import com.lothuialon.clients.fraud.fraudDTO;
import com.lothuialon.clients.notification.notificationClient;
import com.lothuialon.clients.notification.notificationDTO;
import com.lothuialon.user.config.userConfig;
import com.lothuialon.user.dto.userDTO;
import com.lothuialon.user.entity.user;
import com.lothuialon.user.repository.userRepository;
import com.lothuialon.user.service.userService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class userServiceImp implements userService{

    private final userRepository userRepository;
    private final RestTemplate restTemplate;
    private final fraudClient fraudClient;
    private final notificationClient notificationClient;

    @Autowired
    public userServiceImp(userRepository userRepository, RestTemplate restTemplate, fraudClient fraudClient, notificationClient notificationClient) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.fraudClient = fraudClient;
        this.notificationClient = notificationClient;
    }
    



    @Override
    public void registerUser(userDTO userDTO) {
        user newUser = user.builder()
        .firstName(userDTO.getFirstName())
        .lastName(userDTO.getLastName())
        .email(userDTO.getEmail())
        .build();

        userRepository.saveAndFlush(newUser);
        //log.info("{}", newUser.getId());
        //fraudDTO fraudResponse = restTemplate.getForObject("http://FRAUDCHECK/api/v1/fraudcheck/{userId}", fraudDTO.class, newUser.getId());


        fraudDTO fraudResponse = fraudClient.isFraud(newUser.getId());

        if(fraudResponse.isFraud()){
            throw new IllegalStateException("Fraud user");
        }

        notificationClient.sendNotification(

        notificationDTO.builder()
        .toCustomerId(newUser.getId())
        .toCustomerEmail(newUser.getEmail())
        .message(String.format("Welcome to my application, %s", newUser.getFirstName()))
        .build()

        );

    }
    
}
