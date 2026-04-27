package com.mealplanner.recipe_service.dto;

import com.mealplanner.recipe_service.enums.Unit;
import lombok.Data;
import java.util.UUID;

@Data
public class RecipeIngredientRequest {
    private UUID recipeId;
    private UUID ingredientId;
    private double quantity;
    private Unit unit;
}