package com.mealplanner.menu_service.controller;

import com.mealplanner.menu_service.model.MealSlot;
import com.mealplanner.menu_service.service.MealSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/meal-slots")
@RequiredArgsConstructor
public class MealSlotController {

    private final MealSlotService mealSlotService;

    @PostMapping
    public ResponseEntity<MealSlot> createMealSlot(@RequestBody MealSlot mealSlot) {
        return ResponseEntity.ok(mealSlotService.createMealSlot(mealSlot));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealSlot> getMealSlotById(@PathVariable UUID id) {
        return mealSlotService.getMealSlotById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/menu/{menuId}")
    public ResponseEntity<List<MealSlot>> getMealSlotsByMenuId(@PathVariable UUID menuId) {
        return ResponseEntity.ok(mealSlotService.getMealSlotsByMenuId(menuId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MealSlot> updateMealSlot(@RequestBody MealSlot mealSlot) {
        return ResponseEntity.ok(mealSlotService.updateMealSlot(mealSlot));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMealSlot(@PathVariable UUID id) {
        mealSlotService.deleteMealSlot(id);
        return ResponseEntity.noContent().build();
    }
}