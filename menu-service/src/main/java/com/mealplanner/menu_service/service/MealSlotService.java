package com.mealplanner.menu_service.service;

import com.mealplanner.menu_service.client.RecipeServiceClient;
import com.mealplanner.menu_service.model.MealSlot;
import com.mealplanner.menu_service.repository.MealSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MealSlotService {

    private final MealSlotRepository mealSlotRepository;
    private final RecipeServiceClient recipeServiceClient;

    public MealSlot createMealSlot(MealSlot mealSlot) {

        ResponseEntity<Object> recipe = recipeServiceClient.getRecipeById(mealSlot.getRecipeId());
        if (recipe.getStatusCode().is4xxClientError()) {
            throw new RuntimeException("Recipe not found in recipe-service");
        }
        return mealSlotRepository.save(mealSlot);
    }

    public Optional<MealSlot> getMealSlotById(UUID id) {
        return mealSlotRepository.findById(id);
    }

    public List<MealSlot> getMealSlotsByMenuId(UUID menuId) {
        return mealSlotRepository.findByMenuId(menuId);
    }

    public MealSlot updateMealSlot(MealSlot mealSlot) {
        return mealSlotRepository.save(mealSlot);
    }

    public void deleteMealSlot(UUID id) {
        mealSlotRepository.deleteById(id);
    }
}