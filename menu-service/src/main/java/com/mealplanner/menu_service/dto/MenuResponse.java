package com.mealplanner.menu_service.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class MenuResponse {
    private UUID id;
    private UUID userId;
    private LocalDate weekStartDate;
    private LocalDate weekEndDate;
    private boolean isValidated;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}