package com.mealplanner.menu_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "recipe-service")
public interface RecipeServiceClient {

    @GetMapping("/api/recipes/{id}")
    ResponseEntity<Object> getRecipeById(@PathVariable UUID id);
}