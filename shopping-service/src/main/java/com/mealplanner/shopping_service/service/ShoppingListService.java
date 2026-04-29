package com.mealplanner.shopping_service.service;

import com.mealplanner.shopping_service.enums.ShoppingListStatus;
import com.mealplanner.shopping_service.model.ShoppingList;
import com.mealplanner.shopping_service.repository.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;

    public ShoppingList createShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public Optional<ShoppingList> getShoppingListById(UUID id) {
        return shoppingListRepository.findById(id);
    }

    public List<ShoppingList> getShoppingListsByUserId(UUID userId) {
        return shoppingListRepository.findByUserId(userId);
    }

    public List<ShoppingList> getShoppingListsByMenuId(UUID menuId) {
        return shoppingListRepository.findByMenuId(menuId);
    }

    public ShoppingList updateShoppingList(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }

    public ShoppingList completeShoppingList(UUID id) {
        ShoppingList shoppingList = shoppingListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShoppingList not found"));
        shoppingList.setStatus(ShoppingListStatus.COMPLETED);
        return shoppingListRepository.save(shoppingList);
    }

    public void deleteShoppingList(UUID id) {
        shoppingListRepository.deleteById(id);
    }
}