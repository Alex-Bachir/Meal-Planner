package com.mealplanner.shopping_service.repository;

import com.mealplanner.shopping_service.model.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ShoppingItemRepository extends JpaRepository<ShoppingItem, UUID> {

    List<ShoppingItem> findByShoppingListId(UUID shoppingListId);

}
