package com.lothuialon.notification.controller;

import org.springframework.web.bind.annotation.RestController;

import com.lothuialon.clients.notification.notificationDTO;
import com.lothuialon.notification.service.Imp.notificationServiceImp;

import lombok.extern.log4j.Log4j2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Log4j2
public class notificationController {
    
    private final notificationServiceImp notificationService;

    @Autowired
    public notificationController(notificationServiceImp notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping(value="api/v1/notification")
    public void sendNotification(@RequestBody notificationDTO notification) {
        log.info("New notification - {}", notification);
        notificationService.send(notification);
    }
    

}
