package com.lothuialon.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lothuialon.notification.entity.notification;

public interface notificationRepository extends JpaRepository<notification, Integer>{
    
}
