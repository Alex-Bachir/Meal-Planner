package com.mealplanner.menu_service.repository;

import com.mealplanner.menu_service.model.MealSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MealSlotRepository extends JpaRepository<MealSlot, UUID> {
    List<MealSlot> findByMenuId(UUID menuId);
}