package com.example.auth.service;

import com.example.auth.modal.Dashbord;
import com.example.auth.modal.Item;
import com.example.auth.modal.User;

import java.util.List;
import java.util.Optional;

public interface DashbordService {
    Dashbord findOne(Long id);
    List<Dashbord> findAll();
    Dashbord save(Dashbord dashbord);
    Dashbord update(Dashbord dashbord);
    void delete(Long id);
    void delete(Dashbord dashbord);
    Dashbord getDashbordByItem(Long id);

    List<Dashbord> findDashbordsByResponsableAndItemType(Long userId, String itemType);
    List<Dashbord> findDashbordsByUser(Long userId);
}
