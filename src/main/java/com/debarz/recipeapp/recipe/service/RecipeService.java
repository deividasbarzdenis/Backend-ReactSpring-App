package com.debarz.recipeapp.recipe.service;

import com.debarz.recipeapp.recipe.dto.RecipeDTO;
import com.debarz.recipeapp.recipe.mapper.RecipeMapper;
import com.debarz.recipeapp.recipe.model.Recipe;
import com.debarz.recipeapp.recipe.repository.CategoryRepository;
import com.debarz.recipeapp.recipe.repository.MeasureUnitRepository;
import com.debarz.recipeapp.recipe.repository.RecipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;
    private final MeasureUnitRepository measureUnitRepository;
    private final CategoryRepository categoryRepository;


    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll()
                .stream()
                .map(recipeMapper::convertRecipeToDTO)
                .collect(Collectors.toList());
    }
    public RecipeDTO createRecipe(RecipeDTO recipeDTO){
        Recipe recipe = recipeMapper.convertRecipeDTOToEntity(recipeDTO);
        Recipe saveRecipe = recipeRepository.save(recipe);
        recipeDTO.setId(saveRecipe.getId());
        return recipeDTO;
    }
}
