package com.example.auth.service.impl;
import com.example.auth.modal.User;
import com.example.auth.repository.UserRepository;
import com.example.auth.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Service

public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public User findOne(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll()  {
            // some code that may throw an exception
            return repository.findAll();

    }

    @Override
    public User save(User user) {
        return repository.save(user); }


    @Override
    public User update(User user) {
        repository.save(user);


        return user;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void delate(User user) {
        repository.delete(user);
    }


    // Get Current User
    @Transactional
    public long currentUser() {
        SecurityContext principal = SecurityContextHolder.getContext();
        Authentication authentication = principal.getAuthentication();
        System.out.println(authentication.getPrincipal());
        long user = 0 ;
        if (authentication != null)
            if (authentication.getPrincipal() instanceof User)
                user = ((User) authentication.getPrincipal()).getId();
            else if (authentication.getPrincipal() instanceof String)
                user = (long) authentication.getPrincipal();
            return user;
    }
}

