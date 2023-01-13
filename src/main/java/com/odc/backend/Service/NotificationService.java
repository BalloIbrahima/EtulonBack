package com.odc.backend.Service;

import java.util.List;

import com.odc.backend.Models.Notification;

public interface NotificationService {
    
    // Methode pour la création d'une Notification
    Notification saveNotification(Notification notification);

    // Methode pour la modification d'une Notification
    Notification updateNotification(Notification notification);

    // Methode pour la recuperation d'une Notification
    Notification getNotification(Long id);

    // Methode pour la surpression d'une Notification à partir d'une Notification
    void deleteNotification(Notification notification);

    // Methode pour la liste des Notifications
    List<Notification> getAllNotification();
}
