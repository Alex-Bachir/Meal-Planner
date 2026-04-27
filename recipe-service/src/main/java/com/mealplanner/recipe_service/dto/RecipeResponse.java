package com.mealplanner.recipe_service.dto;

import com.mealplanner.recipe_service.enums.Difficulty;
import com.mealplanner.recipe_service.enums.RecipeCategory;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class RecipeResponse {
    private UUID id;
    private UUID userId;
    private String name;
    private String description;
    private String instructions;
    private int preparationTime;
    private int cookingTime;
    private int servings;
    private Difficulty difficulty;
    private RecipeCategory category;
    private String imageUrl;
    private boolean isVegetarian;
    private boolean isVegan;
}