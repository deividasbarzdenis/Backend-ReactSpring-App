package com.debarz.recipeapp.recipe.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {

    //<----RECIPE ENTITY---->//
    private Long id;
    private String recipeDescription;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;

    //<----CATEGORY ENTITY---->//Todo--???
    //**@ManyToMany in Entity**
    private Set<String> categoryDto;

    //<----DIFFICULTY ENTITY---->//
    //**Enum in Entity**
    private String difficulty;

    //<----INGREDIENT ENTITY---->//Todo--???
    //**@OneToMany in Entity**
    private Set<IngredientDTO> ingredientDTO =new HashSet<>();

    //<----NOTES ENTITY---->//
    //**@OneToOne in Entity**
    private String recipeNotes;


}
