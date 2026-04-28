package com.mealplanner.menu_service.dto;

import com.mealplanner.menu_service.enums.DayOfWeek;
import com.mealplanner.menu_service.enums.MealType;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class MealSlotResponse {
    private UUID id;
    private UUID menuId;
    private UUID recipeId;
    private DayOfWeek day;
    private MealType mealType;
    private int servings;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}