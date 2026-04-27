package com.mealplanner.recipe_service.controller;

import com.mealplanner.recipe_service.model.RecipeIngredient;
import com.mealplanner.recipe_service.service.RecipeIngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recipe-ingredients")
@RequiredArgsConstructor
public class RecipeIngredientController {

    private final RecipeIngredientService recipeIngredientService;

    @PostMapping
    public ResponseEntity<RecipeIngredient> addIngredientToRecipe(@RequestBody RecipeIngredient recipeIngredient) {
        return ResponseEntity.ok(recipeIngredientService.addIngredientToRecipe(recipeIngredient));
    }

    @GetMapping("/recipe/{recipeId}")
    public ResponseEntity<List<RecipeIngredient>> getIngredientsByRecipeId(@PathVariable UUID recipeId) {
        return ResponseEntity.ok(recipeIngredientService.getIngredientsByRecipeId(recipeId));
    }

    @GetMapping("/ingredient/{ingredientId}")
    public ResponseEntity<List<RecipeIngredient>> getRecipesByIngredientId(@PathVariable UUID ingredientId) {
        return ResponseEntity.ok(recipeIngredientService.getRecipesByIngredientId(ingredientId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecipeIngredient> updateRecipeIngredient(@RequestBody RecipeIngredient recipeIngredient) {
        return ResponseEntity.ok(recipeIngredientService.updateRecipeIngredient(recipeIngredient));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecipeIngredient(@PathVariable UUID id) {
        recipeIngredientService.deleteRecipeIngredient(id);
        return ResponseEntity.noContent().build();
    }
}