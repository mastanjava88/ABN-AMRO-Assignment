package com.abn.amro.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/* Ingredient Entity class */

@Entity
@Table(name = "INGRIDIENT")
@Data
public class IngredientsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")

    private String quantity;

    public Long getId() {
        return id;
    }

}