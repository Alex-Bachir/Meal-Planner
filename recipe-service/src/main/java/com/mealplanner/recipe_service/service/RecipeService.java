package com.mealplanner.recipe_service.service;

import com.mealplanner.recipe_service.model.Recipe;
import com.mealplanner.recipe_service.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;

    public Recipe createRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public Optional<Recipe> getRecipeById(UUID id) {
        return recipeRepository.findById(id);
    }

    public List<Recipe> getRecipesByUserId(UUID userId) {
        return recipeRepository.findByUserId(userId);
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe updateRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    public void deleteRecipe(UUID id) {
        recipeRepository.deleteById(id);
    }
}