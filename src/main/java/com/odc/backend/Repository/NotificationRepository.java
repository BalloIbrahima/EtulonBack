package com.odc.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odc.backend.Models.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    
}
