package com.debarz.recipeapp.recipe.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(Long id) {
        super("Recipe with id: " + id + " not found!");
    }
}
