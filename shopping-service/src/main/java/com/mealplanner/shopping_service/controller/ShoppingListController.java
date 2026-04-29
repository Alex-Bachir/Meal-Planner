package com.mealplanner.shopping_service.controller;

import com.mealplanner.shopping_service.model.ShoppingList;
import com.mealplanner.shopping_service.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shopping-lists")
@RequiredArgsConstructor
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @PostMapping
    public ResponseEntity<ShoppingList> createShoppingList(@RequestBody ShoppingList shoppingList) {
        return ResponseEntity.ok(shoppingListService.createShoppingList(shoppingList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingList> getShoppingListById(@PathVariable UUID id) {
        return shoppingListService.getShoppingListById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ShoppingList>> getShoppingListsByUserId(@PathVariable UUID userId) {
        return ResponseEntity.ok(shoppingListService.getShoppingListsByUserId(userId));
    }

    @GetMapping("/menu/{menuId}")
    public ResponseEntity<List<ShoppingList>> getShoppingListsByMenuId(@PathVariable UUID menuId) {
        return ResponseEntity.ok(shoppingListService.getShoppingListsByMenuId(menuId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingList> updateShoppingList(@RequestBody ShoppingList shoppingList) {
        return ResponseEntity.ok(shoppingListService.updateShoppingList(shoppingList));
    }

    @PutMapping("/{id}/complete")
    public ResponseEntity<ShoppingList> completeShoppingList(@PathVariable UUID id) {
        return ResponseEntity.ok(shoppingListService.completeShoppingList(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingList(@PathVariable UUID id) {
        shoppingListService.deleteShoppingList(id);
        return ResponseEntity.noContent().build();
    }
}