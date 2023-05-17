package com.example.auth.service.impl;

import com.example.auth.modal.Item;
import com.example.auth.modal.Notification;
import com.example.auth.modal.User;
import com.example.auth.repository.NotificationRepository;
import com.example.auth.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public Notification findOne(Long id) {
        return notificationRepository.findById(id).orElse(null);
    }


    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification update(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public void delete(Long id) {
        notificationRepository.deleteById(id);

    }

    @Override
    public void delete(Notification notification) {

        notificationRepository.delete(notification);
    }

    @Override
    public List<Notification> findAllNotificationsByUser(User user) {
        return notificationRepository.findAllByUserOrderByIdDesc(user);
    }
}
