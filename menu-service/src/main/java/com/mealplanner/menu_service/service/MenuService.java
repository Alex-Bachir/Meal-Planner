package com.mealplanner.menu_service.service;

import com.mealplanner.menu_service.config.MenuEventPublisher;
import com.mealplanner.menu_service.model.Menu;
import com.mealplanner.menu_service.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;
    private final MenuEventPublisher menuEventPublisher;

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Optional<Menu> getMenuById(UUID id) {
        return menuRepository.findById(id);
    }

    public List<Menu> getMenusByUserId(UUID userId) {
        return menuRepository.findByUserId(userId);
    }

    public Menu updateMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu validateMenu(UUID id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
        menu.setValidated(true);
        Menu savedMenu = menuRepository.save(menu);

        // Envoie le message RabbitMQ
        menuEventPublisher.publishMenuValidated(savedMenu.getId());

        return savedMenu;
    }

    public void deleteMenu(UUID id) {
        menuRepository.deleteById(id);
    }
}