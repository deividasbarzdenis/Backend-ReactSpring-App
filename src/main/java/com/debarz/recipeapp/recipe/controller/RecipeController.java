package com.debarz.recipeapp.recipe.controller;

import com.debarz.recipeapp.recipe.dto.RecipeDTO;
import com.debarz.recipeapp.recipe.mapper.RecipeMapper;
import com.debarz.recipeapp.recipe.model.Recipe;
import com.debarz.recipeapp.recipe.service.RecipeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    private RecipeService recipeService;

    @GetMapping
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> addRecipe(@RequestBody @Valid RecipeDTO recipeDTO){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(recipeService.createRecipe(recipeDTO));
    }

    @GetMapping("/{id}")
    public RecipeDTO getRecipe(@PathVariable long id){
        return recipeService.getRecipeById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteRecipe(@PathVariable long id){
        recipeService.deleteRecipe(id);
    }
}
