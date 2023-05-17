package com.example.auth.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity

public class ItemDependence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_first_item", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Item firstItem;
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name = "id_second_item", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Item secondItem;
}
