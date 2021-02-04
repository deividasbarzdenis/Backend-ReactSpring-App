package com.debarz.recipeapp.recipe.repository;

import com.debarz.recipeapp.recipe.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

//    Optional<Category> findByDescription(String description);
}
