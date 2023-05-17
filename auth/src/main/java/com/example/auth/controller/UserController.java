package com.example.auth.controller;
import com.example.auth.modal.ERole;
import com.example.auth.modal.Role;
import com.example.auth.modal.User;
import com.example.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor

public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder encoder;

    @GetMapping(path = "/getALluserr")
    public List<User> getuser(){
        return userService.findAll();
    }
    @PostMapping(path = "/saveuser")
    public User saveuser(@RequestBody User user ) {

        String newpassword=encoder.encode(user.getPassword());
        user.setPassword(newpassword);
        return userService.save(user);
    }

    @GetMapping(path = "/getUSER/{id}")
    public User getuser(@PathVariable Long id) {return userService.findOne(id);}

    @DeleteMapping (path = "/deletUser/{id}")
    public ResponseEntity<Void> deleteuser(@PathVariable Long id){userService.delete(id);return ResponseEntity.noContent().build();}

    @PutMapping (path = "/updateuser")
    public User apdateuser(@RequestBody User user ){
        return userService.update(user);
    }
    @GetMapping(path = "/getAllROLE_MODERATOR")
    public List<User> getAllROLE_MODERATOR() {
        List<User> users = userService.findAll();
        List<User> moderators = new ArrayList<>();
        for (User user : users) {
            for (Role role : user.getRoles()) {
                if (role.getName().equals(ERole.ROLE_MODERATOR)) {
                    moderators.add(user);
                    break;
                }
            }
        }
        return moderators;
    }
    @GetMapping(path = "/getAllROLE_ADMIN")
    public List<User> getAllROLE_ADMIN() {
        List<User> users = userService.findAll();
        List<User> admins = new ArrayList<>();
        for (User user : users) {
            for (Role role : user.getRoles()) {
                if (role.getName().equals(ERole.ROLE_ADMIN)) {
                    admins.add(user);
                    break;
                }
            }
        }
        return admins;
    }

    @GetMapping(path = "/getAllROLE_USER")
    public List<User> getAllROLE_USER() {
        List<User> users = userService.findAll();
        List<User> simpleUsers = new ArrayList<>();
        for (User user : users) {
            for (Role role : user.getRoles()) {
                if (role.getName().equals(ERole.ROLE_USER)) {
                    simpleUsers.add(user);
                    break;
                }
            }
        }
        return simpleUsers;
    }


}
