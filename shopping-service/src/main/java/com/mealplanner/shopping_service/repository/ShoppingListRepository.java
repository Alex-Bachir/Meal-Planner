package com.mealplanner.shopping_service.repository;

import com.mealplanner.shopping_service.model.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, UUID> {
    List<ShoppingList> findByUserId(UUID userId);
    List<ShoppingList> findByMenuId(UUID menuId);



}
