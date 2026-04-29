package com.mealplanner.recipe_service.model;

import com.mealplanner.recipe_service.enums.Unit;
import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipe_ingredients")
public class RecipeIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, name = "recipe_id")
    private UUID recipeId;

    @Column(nullable = false, name = "ingredient_id")
    private UUID ingredientId;

    @Column(nullable = false)
    private double quantity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Unit unit;
}