package com.lothuialon.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;



@FeignClient(value = "NOTIFICATION")
public interface notificationClient {
    
    @PostMapping(value="api/v1/notification")
    void sendNotification(notificationDTO notificationDTO);

}
