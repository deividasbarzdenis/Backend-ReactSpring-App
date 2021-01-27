package com.debarz.recipeapp.user.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id){
        super("Entry with id: " + id + " was not found");
    }
}
