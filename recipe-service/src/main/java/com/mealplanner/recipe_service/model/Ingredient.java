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
    @Column(name = "image_url")
    private String imageUrl;
    private String category;
    @Column(name = "is_vegan")
    private boolean isVegan;
    @Column(name = "is_vegetarian")
    private boolean isVegetarian;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> allergens;

    @Column(name = "nutri_score")
    private String nutriScore;
    private double calories;
    private double proteins;
    private double carbohydrates;
    private double fat;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}