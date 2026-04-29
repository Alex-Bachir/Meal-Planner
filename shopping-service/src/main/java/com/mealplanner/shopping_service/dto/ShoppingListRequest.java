package com.mealplanner.shopping_service.dto;

import com.mealplanner.shopping_service.enums.ShoppingListStatus;
import lombok.Data;
import java.util.UUID;

@Data
public class ShoppingListRequest {
    private UUID userId;
    private UUID menuId;
    private ShoppingListStatus status;
}