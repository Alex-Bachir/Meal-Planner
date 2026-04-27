package com.mealplanner.profile_service.dto;

import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
public class ProfileRequest {
    private UUID userId;
    private String pseudo;
    private String avatar;
    private boolean isVegetarian;
    private boolean isVegan;
    private boolean isGlutenFree;
    private boolean isLactoseFree;
    private List<String> allergies;
}