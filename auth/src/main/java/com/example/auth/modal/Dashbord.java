package com.example.auth.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
public class Dashbord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @JsonIgnoreProperties({"hibernatelazyinitializer","handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by_id",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User createdBy ;
    //respensable
    @JsonIgnoreProperties({"hibernatelazyinitializer","handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "responsable_id",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User responsable ;

    //projet
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id",referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Item item ;
}
