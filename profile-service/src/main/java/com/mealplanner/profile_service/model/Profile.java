package com.mealplanner.profile_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "user_id")
    private UUID userId;
    private String pseudo;
    private String avatar;

    @Column(name = "is_vegetarian")
    private boolean isVegetarian;

    @Column(name = "is_vegan")
    private boolean isVegan;

    @Column(name = "is_gluten_free")
    private boolean isGlutenFree;

    @Column(name = "is_lactose_free")
    private boolean isLactoseFree;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> allergies;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
