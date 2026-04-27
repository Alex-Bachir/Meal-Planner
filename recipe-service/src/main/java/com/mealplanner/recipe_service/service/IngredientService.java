package com.mealplanner.recipe_service.service;

import com.mealplanner.recipe_service.model.Ingredient;
import com.mealplanner.recipe_service.repository.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public Optional<Ingredient> getIngredientById(UUID id) {
        return ingredientRepository.findById(id);
    }

    public Optional<Ingredient> getIngredientByBarcode(String barcode) {
        return ingredientRepository.findByBarcode(barcode);
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public Ingredient updateIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public void deleteIngredient(UUID id) {
        ingredientRepository.deleteById(id);
    }
}