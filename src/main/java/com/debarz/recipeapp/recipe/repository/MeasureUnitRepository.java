package com.debarz.recipeapp.recipe.repository;

import com.debarz.recipeapp.recipe.model.MeasureUnit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MeasureUnitRepository extends JpaRepository<MeasureUnit, Long> {

//    Optional<MeasureUnit> findByDescription(String description);
}
