package com.mealplanner.shopping_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "menu-service")
public interface MenuServiceClient {

    @GetMapping("/api/meal-slots/menu/{menuId}")
    ResponseEntity<List<Object>> getMealSlotsByMenuId(@PathVariable UUID menuId);
}