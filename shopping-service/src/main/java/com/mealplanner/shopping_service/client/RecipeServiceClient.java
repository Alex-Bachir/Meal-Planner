package com.mealplanner.shopping_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "recipe-service")
public interface RecipeServiceClient {

    @GetMapping("/api/recipe-ingredients/recipe/{recipeId}")
    ResponseEntity<List<Object>> getIngredientsByRecipeId(@PathVariable UUID recipeId);
}