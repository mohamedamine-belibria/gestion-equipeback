package com.example.auth.modal;
import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity

public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String title;
    private String description;
    private Date datedecreation;
    private Date dedline;

    @Enumerated(EnumType.STRING)
    private Statut statut;

}
