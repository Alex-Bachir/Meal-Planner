package com.mealplanner.shopping_service.service;

import com.mealplanner.shopping_service.model.ShoppingItem;
import com.mealplanner.shopping_service.repository.ShoppingItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingItemService {

    private final ShoppingItemRepository shoppingItemRepository;

    public ShoppingItem createShoppingItem(ShoppingItem shoppingItem) {
        return shoppingItemRepository.save(shoppingItem);
    }

    public Optional<ShoppingItem> getShoppingItemById(UUID id) {
        return shoppingItemRepository.findById(id);
    }

    public List<ShoppingItem> getShoppingItemsByShoppingListId(UUID shoppingListId) {
        return shoppingItemRepository.findByShoppingListId(shoppingListId);
    }

    public ShoppingItem checkShoppingItem(UUID id) {
        ShoppingItem shoppingItem = shoppingItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShoppingItem not found"));
        shoppingItem.setChecked(true);
        return shoppingItemRepository.save(shoppingItem);
    }

    public ShoppingItem updateShoppingItem(ShoppingItem shoppingItem) {
        return shoppingItemRepository.save(shoppingItem);
    }

    public void deleteShoppingItem(UUID id) {
        shoppingItemRepository.deleteById(id);
    }
}
