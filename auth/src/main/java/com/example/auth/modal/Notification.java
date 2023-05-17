package com.example.auth.modal;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;
    private String message;
    
}
