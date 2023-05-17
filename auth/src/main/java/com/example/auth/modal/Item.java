package com.example.auth.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String itemType;
    private String name;
    private String description;
    private String dateCreation;
    private String dateFinProjet;
    private String dedline;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @JsonIgnore
    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private List<Dashbord> dashbords;
    @JsonIgnore
    @OneToMany(mappedBy = "firstItem")
    private List<ItemDependence>firstItems;

    @JsonIgnore
    @OneToMany(mappedBy = "secondItem")
    private List<ItemDependence>secondItems;
}
