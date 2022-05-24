package com.abn.amro.dto;

import com.abn.amro.model.IngredientsEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Data
public class RecipeDTO {
    private Long id;


    @Length(min = 3, message = "The field must be at least 3 characters")
    @Length(max = 50, message = "The field must be less than 50 characters")
    private String name;


    private Float price;

    private String type;

    @NotNull(message = "Recipe Cooking instructions are required")
    @NotBlank(message = "Recipe Cooking instructions  must be of length 1 to 1500")
    @Size(min = 1, max = 1500, message = "Recipe Cooking instructions must be of length 1 to 1500")
    private String cookingInstructions;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd‐MM‐yyyy HH:mm")
    private Date creationDate;

    @NotNull(message = "Recipe Ingredients required")
    @NotEmpty(message = "Recipe Ingredients Required")
    private List<IngredientsEntity> ingredients;

}
