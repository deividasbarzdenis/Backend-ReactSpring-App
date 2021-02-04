package com.debarz.recipeapp.bandymas;

import com.debarz.recipeapp.recipe.dto.CategoryDTO;
import com.debarz.recipeapp.recipe.dto.IngredientDTO;
import com.debarz.recipeapp.recipe.dto.RecipeDTO;
import com.debarz.recipeapp.recipe.model.*;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BandymasToEntity {
    public static void main(String[] args) {
        Recipe recipe = new Recipe();
        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setRecipeDescription("ToEntity");
        recipeDTO.setPrepTime(1);
        recipeDTO.setCookTime(1);
        recipeDTO.setServings(1);
        recipeDTO.setSource("ToEntity");
        recipeDTO.setUrl("ToEntity");
        recipeDTO.setDirections("ToEntity");

        Set<String> categoriesDTOList = new HashSet<>();
        categoriesDTOList.add("Mexican");
        categoriesDTOList.add("Lithuanian");
        recipeDTO.setCategoryDto(categoriesDTOList);

        recipeDTO.setDifficulty("HARD");

        Set<IngredientDTO> ingredientDTOList = new HashSet<>();
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setIngredientDescription("ToEntity");
        ingredientDTO.setAmount(new BigDecimal(2));
        ingredientDTO.setMuDescription("L");

        IngredientDTO ingredientDTO1 = new IngredientDTO();
        ingredientDTO1.setIngredientDescription("ToEntity1");
        ingredientDTO1.setAmount(new BigDecimal(3));
        ingredientDTO1.setMuDescription("ML");

        ingredientDTOList.add(ingredientDTO);
        ingredientDTOList.add(ingredientDTO1);
        recipeDTO.setIngredientDTO(ingredientDTOList);

        recipeDTO.setRecipeNotes("ToEntity");

        recipe.setRecipeDescription(recipeDTO.getRecipeDescription());
        recipe.setPrepTime(recipeDTO.getPrepTime());
        recipe.setCookTime(recipeDTO.getCookTime());
        recipe.setServings(recipeDTO.getServings());
        recipe.setSource(recipeDTO.getSource());
        recipe.setUrl(recipeDTO.getUrl());
        recipe.setDirections(recipeDTO.getDirections());

        recipe.setIngredients(recipeDTO.getIngredientDTO().stream()
                .map(ingredientDTOMap -> {
                    Ingredient ingredient = new Ingredient();
                    MeasureUnit measureUnit = new MeasureUnit();
                    ingredient.setIngredientDescription(ingredientDTOMap.getIngredientDescription());
                    ingredient.setAmount(ingredientDTOMap.getAmount());
                    return ingredient;
                }).collect(Collectors.toSet()));

        recipe.setDifficulty(Difficulty.valueOf(recipeDTO.getDifficulty()));

        Notes notes = new Notes();
        notes.setRecipeNotes(recipeDTO.getRecipeNotes());
        recipe.setNotes(notes);

        recipe.setCategories(recipeDTO.getCategoryDto().stream()
                .map(categoryDtoMap -> {
                    Category category = new Category();
                    category.setCategoryDescription(categoryDtoMap);
                    return category;
                })
                .collect(Collectors.toSet()));

        System.out.println((recipe.toString()));
    }

}
