package com.mealplanner.shopping_service.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class ShoppingItemRequest {
    private UUID shoppingListId;
    private UUID ingredientId;
    private String ingredientName;
    private double quantity;
    private String unit;
}