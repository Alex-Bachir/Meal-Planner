package com.mealplanner.recipe_service.service;

import com.mealplanner.recipe_service.model.RecipeIngredient;
import com.mealplanner.recipe_service.repository.RecipeIngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeIngredientService {

    private final RecipeIngredientRepository recipeIngredientRepository;

    public RecipeIngredient addIngredientToRecipe(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepository.save(recipeIngredient);
    }

    public List<RecipeIngredient> getIngredientsByRecipeId(UUID recipeId) {
        return recipeIngredientRepository.findByRecipeId(recipeId);
    }

    public List<RecipeIngredient> getRecipesByIngredientId(UUID ingredientId) {
        return recipeIngredientRepository.findByIngredientId(ingredientId);
    }

    public RecipeIngredient updateRecipeIngredient(RecipeIngredient recipeIngredient) {
        return recipeIngredientRepository.save(recipeIngredient);
    }

    public void deleteRecipeIngredient(UUID id) {
        recipeIngredientRepository.deleteById(id);
    }
}