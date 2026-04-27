package com.mealplanner.profile_service.repository;

import com.mealplanner.profile_service.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    Optional<Profile> findById(UUID userId);
    Optional<Profile> findByUserId(UUID userId);

}
