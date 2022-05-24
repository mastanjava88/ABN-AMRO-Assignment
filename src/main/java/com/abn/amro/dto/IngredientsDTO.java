package com.abn.amro.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class IngredientsDTO {

    private Long id;

    @Length(min = 3, message = "The field must be at least 3 characters")
    @Length(max = 50, message = "The field must be less than 50 characters")
    private String name;

    @Length(max = 10, message = "The field must be less than 10 characters")
    private String quantity;
}
