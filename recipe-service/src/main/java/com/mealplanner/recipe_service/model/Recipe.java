package com.mealplanner.recipe_service.model;

import com.mealplanner.recipe_service.enums.Difficulty;
import com.mealplanner.recipe_service.enums.RecipeCategory;
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
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, name = "user_id")
    private UUID userId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(columnDefinition = "TEXT")
    private String instructions;

    @Column(name = "preparation_time")
    private int preparationTime;
    @Column(name = "cooking_time")
    private int cookingTime;
    private int servings;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Enumerated(EnumType.STRING)
    private RecipeCategory category;

    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "is_vegetarian")
    private boolean isVegetarian;
    @Column(name = "is_vegan")
    private boolean isVegan;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}