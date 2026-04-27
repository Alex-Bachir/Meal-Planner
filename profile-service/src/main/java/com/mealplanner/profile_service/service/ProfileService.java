package com.mealplanner.profile_service.service;

import com.mealplanner.profile_service.model.Profile;
import com.mealplanner.profile_service.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public Optional<Profile> getProfileById(UUID id) {
        return profileRepository.findById(id);
    }

    public Optional<Profile> getProfileByUserId(UUID userId) {
        return profileRepository.findByUserId(userId);
    }

    public Profile updateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public void deleteProfile(UUID id) {
        profileRepository.deleteById(id);
    }
}