package com.mealplanner.shopping_service.controller;

import com.mealplanner.shopping_service.model.ShoppingItem;
import com.mealplanner.shopping_service.service.ShoppingItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shopping-items")
@RequiredArgsConstructor
public class ShoppingItemController {

    private final ShoppingItemService shoppingItemService;

    @PostMapping
    public ResponseEntity<ShoppingItem> createShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        return ResponseEntity.ok(shoppingItemService.createShoppingItem(shoppingItem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingItem> getShoppingItemById(@PathVariable UUID id) {
        return shoppingItemService.getShoppingItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/list/{shoppingListId}")
    public ResponseEntity<List<ShoppingItem>> getShoppingItemsByShoppingListId(@PathVariable UUID shoppingListId) {
        return ResponseEntity.ok(shoppingItemService.getShoppingItemsByShoppingListId(shoppingListId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShoppingItem> updateShoppingItem(@RequestBody ShoppingItem shoppingItem) {
        return ResponseEntity.ok(shoppingItemService.updateShoppingItem(shoppingItem));
    }

    @PutMapping("/{id}/check")
    public ResponseEntity<ShoppingItem> checkShoppingItem(@PathVariable UUID id) {
        return ResponseEntity.ok(shoppingItemService.checkShoppingItem(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShoppingItem(@PathVariable UUID id) {
        shoppingItemService.deleteShoppingItem(id);
        return ResponseEntity.noContent().build();
    }
}