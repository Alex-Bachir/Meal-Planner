package com.mealplanner.shopping_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shopping_items")
public class ShoppingItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, name = "shopping_list_item")
    private UUID shoppingListId;

    @Column(nullable = false, name = "ingredient_id")
    private UUID ingredientId;

    @Column(nullable = false, name = "ingredient_name")
    private String ingredientName;

    private double quantity;
    private String unit;
    @Column(name = "is_checked")
    private boolean isChecked;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}