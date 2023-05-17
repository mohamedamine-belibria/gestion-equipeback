package com.example.auth.controller;

import com.example.auth.modal.*;
import com.example.auth.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(value = "*")
@RequiredArgsConstructor
@RestController
public class DashbordController  {
    @Autowired
    private ItemDependenceService itemDependenceService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private DashbordService dashbordService;


    @PostMapping(path = "/creationitem/{userId}")
    public Item saveprojet(@PathVariable Long userId, @RequestBody Item item){
        //long createdById=userService.currentUser();
       User createdBy=userService.findOne(userId);
        Optional<Item>saveItem=Optional.of(itemService.save(item));
        saveItem.ifPresent(i ->{
            Dashbord savedDashbord=new Dashbord();
            savedDashbord.setItem(i);
            savedDashbord.setCreatedBy(createdBy);
            dashbordService.save(savedDashbord);
        });
        return item;
    }

    // Assigne Item To User affectation kima el post
    @GetMapping("/assignment/assign/{userId}/{itemId}")
    public ResponseEntity<?> assignItemToUser(@PathVariable Long userId, @PathVariable Long itemId) {

        User user=userService.findOne(userId);
        Dashbord dashbord =dashbordService.getDashbordByItem(itemId);
        dashbord.setResponsable(user);
        dashbordService.save(dashbord);
        //notification
        Notification notification =new Notification();
        notification.setUser(user);
        notification.setMessage("new projet");
        notificationService.save(notification);
        return ResponseEntity.noContent().build();
    }
    //appi notification
    @GetMapping("/getnotificationsByUser/{userId}")
    public List<Notification> getnotificationsByUser(@PathVariable Long userId){
        User user=userService.findOne(userId);
        return notificationService.findAllNotificationsByUser(user);

    }



    //get All projet By userId
    @GetMapping("/projetsByUser/{userId}")
    public List<Dashbord> getProjetsByResponsable(@PathVariable Long userId){
        User user=userService.findOne(userId);
        return dashbordService.findDashbordsByResponsableAndItemType(userId, "PROJET");
    }
    @GetMapping("/tachesByUser/{userId}")
    public List<Dashbord> getTachesByResponsable(@PathVariable Long userId){
        User user=userService.findOne(userId);
        return dashbordService.findDashbordsByResponsableAndItemType(userId, "TACHE");
    }

    //get all projet
    @GetMapping("/getAllProjets")
    public List<Item> getAllProjets() {

        return itemService.findByItemType("PROJET");
    }
//affeccter de puis le projet une tache vers un user
    @GetMapping("/assignment/tache/{tacheId}/{projetId}")
    public ResponseEntity<?> assignTacheToprojet(@PathVariable Long tacheId, @PathVariable Long projetId) {
        Item tache=itemService.findOne(tacheId);
        Item projet=itemService.findOne(projetId);
        Optional<ItemDependence> isExiste=itemDependenceService.findBySecondItem(tache);
       if (!isExiste.isPresent()){
           ItemDependence itemDependence =new ItemDependence();
           itemDependence.setFirstItem(projet);
           itemDependence.setSecondItem(tache);
           itemDependenceService.save(itemDependence);
       }
       return ResponseEntity.noContent().build();
    }
    @GetMapping("/getAllTasks")
    public List<Item> getAllTasks() {

        return itemService.findByItemType("TACHE");
    }
    @GetMapping("/getAllProjectByUserAndType/{userId}")
    public List<Dashbord> getAllProjectByUserAndType(@PathVariable Long userId) {

        return dashbordService.findDashbordsByResponsableAndItemType(userId, "PROJET" );

    }
    @GetMapping("/getTacheversResponsable/{userId}")
    public List<Dashbord> getTacheversResponsable(@PathVariable Long userId) {

        return dashbordService.findDashbordsByResponsableAndItemType(userId, "TACHE" );

    }
    @GetMapping("/getAllTaskByUser/{userId}")
    public List<Dashbord> getAllTaskByUser(@PathVariable Long userId) {

        return dashbordService.findDashbordsByUser(userId);

    }




}
