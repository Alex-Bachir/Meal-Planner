package com.mealplanner.menu_service.dto;

import com.mealplanner.menu_service.enums.DayOfWeek;
import com.mealplanner.menu_service.enums.MealType;
import lombok.Data;
import java.util.UUID;

@Data
public class MealSlotRequest {
    private UUID menuId;
    private UUID recipeId;
    private DayOfWeek day;
    private MealType mealType;
    private int servings;
}