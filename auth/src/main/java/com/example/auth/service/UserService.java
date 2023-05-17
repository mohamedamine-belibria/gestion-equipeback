package com.example.auth.service;
import com.example.auth.modal.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User findOne(Long id);
    List<User> findAll();
    User save(User user);
    User update(User user);
    void delete(Long id);
    void delate (User user);
    long currentUser();

}
