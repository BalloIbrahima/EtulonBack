package com.odc.backend.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.odc.backend.Models.Notification;
import com.odc.backend.Repository.NotificationRepository;
import com.odc.backend.Service.NotificationService;
@Service
public class NotificationImpl implements NotificationService {

    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public Notification saveNotification(Notification notification) {
        // TODO Auto-generated method stub
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(Notification notification) {
        // TODO Auto-generated method stub
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getNotification(Long id) {
        // TODO Auto-generated method stub
        return notificationRepository.findById(id).get();
    }

    @Override
    public void deleteNotification(Notification notification) {
        // TODO Auto-generated method stub
        notificationRepository.delete(notification);
    }

    @Override
    public List<Notification> getAllNotification() {
        // TODO Auto-generated method stub
        return notificationRepository.findAll();
    }
    
}
