package com.mealplanner.menu_service.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class MenuRequest {
    private UUID userId;
    private LocalDate weekStartDate;
    private LocalDate weekEndDate;
}