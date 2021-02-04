package com.debarz.recipeapp.recipe.dto;

import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IngredientDTO {

    private Long id;
    private String ingredientDescription;
    private BigDecimal amount;

    //<----MEASUREUNIT ENTITY---->//
    //**@OneToOne in Entity
    private String muDescription;



}
