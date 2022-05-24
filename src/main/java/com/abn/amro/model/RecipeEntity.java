package com.abn.amro.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/* RECIPE Entity class with one to many mapping */

@Entity
@Table(name="RECIPE")
@Data
public class RecipeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name")
    private String name;


    @Column(name="price")
    private Float price;

	@CreationTimestamp
	@Column(name="creation_date")
	private Date creationDate ;

	@Column(name="type")
	private String type;

	@Column(name = "cooking_instructions")
	private String cookingInstructions;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = IngredientsEntity.class)
	@JoinColumn(name = "ref_id", referencedColumnName = "id", nullable = false)
	private Set<IngredientsEntity> ingredients;
}