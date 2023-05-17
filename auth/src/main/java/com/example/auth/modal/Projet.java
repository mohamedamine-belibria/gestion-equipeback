package com.example.auth.modal;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity

public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String description;
    private Date dateCreation;
    private Date dateFinProjet;
    @Enumerated(EnumType.STRING)
    private Statut statut;

}
