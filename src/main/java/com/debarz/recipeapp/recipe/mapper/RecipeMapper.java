package com.debarz.recipeapp.recipe.mapper;

import com.debarz.recipeapp.recipe.dto.IngredientDTO;
import com.debarz.recipeapp.recipe.dto.RecipeDTO;
import com.debarz.recipeapp.recipe.model.*;
import com.debarz.recipeapp.recipe.repository.MeasureUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class RecipeMapper {

    private MeasureUnitRepository measureUnitRepository;

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
                    ingredient.setIngredientDescription(ingredientDTOMap.getIngredientDescription());
                    ingredient.setAmount(ingredientDTOMap.getAmount());
                    MeasureUnit mu = measureUnitRepository.getOne(Long.parseLong(ingredientDTOMap.getMuDescription()));
                    ingredient.setMu(mu);
                    recipe.addIngredient(ingredient);
                    return ingredient;
                }).collect(Collectors.toSet()));

        convertDifficulty(recipeDTO, recipe);

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

    private void convertDifficulty(RecipeDTO recipeDTO, Recipe recipe) {
        switch (recipeDTO.getDifficulty()) {
            case "1":
                recipe.setDifficulty(Difficulty.EASY);
                break;
            case "2":
                recipe.setDifficulty(Difficulty.MODERATE);
                break;
            case "3":
                recipe.setDifficulty(Difficulty.KIND_OF_HARD);
                break;
            case "4":
                recipe.setDifficulty(Difficulty.HARD);
                break;
            default:
                recipe.setDifficulty(Difficulty.EASY);
        }
    }
}
