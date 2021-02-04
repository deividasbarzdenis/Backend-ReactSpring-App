package com.debarz.recipeapp.recipe.mapper;

import com.debarz.recipeapp.recipe.dto.IngredientDTO;
import com.debarz.recipeapp.recipe.dto.RecipeDTO;
import com.debarz.recipeapp.recipe.model.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeMapper {

    public RecipeDTO convertRecipeToDTO(Recipe recipe) {

        RecipeDTO recipeDTO = new RecipeDTO();

        recipeDTO.setId(recipe.getId());
        recipeDTO.setRecipeDescription(recipe.getRecipeDescription());
        recipeDTO.setPrepTime(recipe.getPrepTime());
        recipeDTO.setCookTime(recipe.getCookTime());
        recipeDTO.setServings(recipe.getServings());
        recipeDTO.setSource(recipe.getSource());
        recipeDTO.setUrl(recipe.getUrl());
        recipeDTO.setDirections(recipe.getDirections());
        recipeDTO.setCategoryDto(recipe.getCategories().stream()
                .map(Category::getCategoryDescription)
                .collect(Collectors.toSet()));
        recipeDTO.setDifficulty(recipe.getDifficulty().name());
        recipeDTO.setIngredientDTO(recipe.getIngredients().stream()
                .map(ingredient -> {
                    IngredientDTO ingredientDTO = new IngredientDTO();
                    ingredientDTO.setIngredientDescription(ingredient.getIngredientDescription());
                    ingredientDTO.setAmount(ingredient.getAmount());
                    ingredientDTO.setMuDescription(ingredient.getMu().getMuDescription());
                    return ingredientDTO;
                }).collect(Collectors.toSet()));
        recipeDTO.setRecipeNotes(recipe.getNotes().getRecipeNotes());

        return recipeDTO;
    }

    public Recipe convertRecipeDTOToEntity(RecipeDTO recipeDTO) {

        Recipe recipe = new Recipe();
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
                    measureUnit.setMuDescription(ingredientDTOMap.getMuDescription());
                    recipe.addIngredient(ingredient);
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

        return recipe;
    }
}
