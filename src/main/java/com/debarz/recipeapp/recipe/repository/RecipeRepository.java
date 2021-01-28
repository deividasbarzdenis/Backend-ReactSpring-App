package com.debarz.recipeapp.recipe.repository;

import com.debarz.recipeapp.recipe.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
