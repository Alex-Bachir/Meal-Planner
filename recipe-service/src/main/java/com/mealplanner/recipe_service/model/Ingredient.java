package com.mealplanner.recipe_service.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String barcode;
    private String name;
    private String imageUrl;
    private String category;
    private boolean isVegan;
    private boolean isVegetarian;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> allergens;

    private String nutriScore;
    private double calories;
    private double proteins;
    private double carbohydrates;
    private double fat;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}