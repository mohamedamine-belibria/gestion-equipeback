package com.example.auth.service.impl;

import com.example.auth.modal.Dashbord;
import com.example.auth.modal.User;
import com.example.auth.repository.DashbordRepository;
import com.example.auth.service.DashbordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DashbordServiceImpl implements DashbordService {
    @Autowired
    private DashbordRepository dashbordRepository;

    @Override
    public Dashbord findOne(Long id) {
        return dashbordRepository.findById(id).orElse(null);
    }

    @Override
    public List<Dashbord> findAll() {
        return dashbordRepository.findAll();
    }

    @Override
    public Dashbord save(Dashbord dashbord) {
        return dashbordRepository.save(dashbord);
    }

    @Override
    public Dashbord update(Dashbord dashbord) {
        return dashbordRepository.save(dashbord);
    }

    @Override
    public void delete(Long id) {
        dashbordRepository.deleteById(id);

    }

    @Override
    public void delete(Dashbord dashbord) {
        dashbordRepository.delete(dashbord);
    }

    @Override
    public Dashbord getDashbordByItem(Long id) {
        return dashbordRepository.findByItemId(id);
    }

    @Override
    public List<Dashbord> findDashbordsByResponsableAndItemType(Long userId, String itemType) {
        return dashbordRepository.findDashbordsByResponsableAndItemType(userId,itemType);
    }

    @Override
    public List<Dashbord> findDashbordsByUser(Long userId) {
        return dashbordRepository.findDashbordsByUser(userId);
    }


}
