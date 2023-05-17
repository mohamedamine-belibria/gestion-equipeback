package com.example.auth.repository;

import com.example.auth.modal.Notification;
import com.example.auth.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findAllByUserOrderByIdDesc(User user);
}
