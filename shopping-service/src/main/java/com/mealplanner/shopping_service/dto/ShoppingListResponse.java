package com.mealplanner.shopping_service.dto;

import com.mealplanner.shopping_service.enums.ShoppingListStatus;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class ShoppingListResponse {
    private UUID id;
    private UUID userId;
    private UUID menuId;
    private ShoppingListStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}