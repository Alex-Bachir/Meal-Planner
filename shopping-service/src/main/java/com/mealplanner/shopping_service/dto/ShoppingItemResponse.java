package com.mealplanner.shopping_service.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ShoppingItemResponse {
    private UUID id;
    private UUID shoppingListId;
    private UUID ingredientId;
    private String ingredientName;
    private double quantity;
    private String unit;
    private boolean isChecked;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}