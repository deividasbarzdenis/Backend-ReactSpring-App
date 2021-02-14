package com.debarz.recipeapp.recipe.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ingredientDescription;
    private BigDecimal amount;

    @OneToOne(fetch = FetchType.EAGER)
    private MeasureUnit mu;

    @ManyToOne
    private Recipe recipe;

    public void addMu(MeasureUnit mu) {
        if (mu != null) {
            this.mu = mu;
        }
    }

    public Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, MeasureUnit mu) {
        this.ingredientDescription = description;
        this.amount = amount;
        this.mu = mu;
    }

    public Ingredient(String description, BigDecimal amount, MeasureUnit mu, Recipe recipe) {
        this.ingredientDescription = description;
        this.amount = amount;
        this.mu = mu;
        this.recipe = recipe;
    }
}
