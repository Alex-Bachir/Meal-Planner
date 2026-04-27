package com.mealplanner.recipe_service.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class IngredientResponse {
    private UUID id;
    private String barcode;
    private String name;
    private String imageUrl;
    private String category;
    private boolean isVegetarian;
    private boolean isVegan;
    private List<String> allergens;
    private String nutriScore;
    private double calories;
    private double proteins;
    private double carbohydrates;
    private double fat;
}