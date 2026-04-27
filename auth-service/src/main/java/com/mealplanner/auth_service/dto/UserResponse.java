package com.mealplanner.auth_service.dto;

import com.mealplanner.auth_service.enums.Role;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserResponse {
    private UUID id;
    private String email;
    private Role role;
    private boolean enabled;
}