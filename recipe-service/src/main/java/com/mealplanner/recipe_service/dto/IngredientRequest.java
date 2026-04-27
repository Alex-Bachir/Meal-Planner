package com.mealplanner.recipe_service.dto;

import lombok.Data;
import java.util.List;

@Data
public class IngredientRequest {
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