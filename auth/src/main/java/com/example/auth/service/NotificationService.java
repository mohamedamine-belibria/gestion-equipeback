package com.example.auth.service;

import com.example.auth.modal.Notification;
import com.example.auth.modal.Tache;
import com.example.auth.modal.User;

import java.util.List;
import java.util.Optional;

public interface NotificationService {

    Notification findOne(Long id);
    List<Notification> findAll();
    Notification save(Notification notification);
    Notification update(Notification notification);
    void delete(Long id);
    void delete(Notification notification);
     List<Notification> findAllNotificationsByUser(User user);

}