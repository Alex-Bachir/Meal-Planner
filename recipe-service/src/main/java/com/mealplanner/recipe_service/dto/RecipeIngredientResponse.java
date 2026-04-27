package com.mealplanner.recipe_service.dto;

import com.mealplanner.recipe_service.enums.Unit;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class RecipeIngredientResponse {
    private UUID id;
    private UUID recipeId;
    private UUID ingredientId;
    private double quantity;
    private Unit unit;
}