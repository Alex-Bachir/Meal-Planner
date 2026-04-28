package com.mealplanner.menu_service.controller;

import com.mealplanner.menu_service.model.Menu;
import com.mealplanner.menu_service.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/menus")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        return ResponseEntity.ok(menuService.createMenu(menu));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> getMenuById(@PathVariable UUID id) {
        return menuService.getMenuById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Menu>> getMenusByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(menuService.getMenusByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updateMenu(@RequestBody Menu menu) {
        return ResponseEntity.ok(menuService.updateMenu(menu));
    }

    @PutMapping("/{id}/validate")
    public ResponseEntity<Menu> validateMenu(@PathVariable UUID id) {
        return ResponseEntity.ok(menuService.validateMenu(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable UUID id) {
        menuService.deleteMenu(id);
        return ResponseEntity.noContent().build();
    }
}