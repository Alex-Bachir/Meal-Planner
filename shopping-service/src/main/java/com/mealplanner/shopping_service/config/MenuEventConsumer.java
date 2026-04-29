package com.mealplanner.shopping_service.config;

import com.mealplanner.shopping_service.client.MenuServiceClient;
import com.mealplanner.shopping_service.client.RecipeServiceClient;
import com.mealplanner.shopping_service.enums.ShoppingListStatus;
import com.mealplanner.shopping_service.model.ShoppingItem;
import com.mealplanner.shopping_service.model.ShoppingList;
import com.mealplanner.shopping_service.service.ShoppingItemService;
import com.mealplanner.shopping_service.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MenuEventConsumer {

    private final ShoppingListService shoppingListService;
    private final ShoppingItemService shoppingItemService;
    private final MenuServiceClient menuServiceClient;
    private final RecipeServiceClient recipeServiceClient;

    @RabbitListener(queues = "menu.validated.queue")
    public void handleMenuValidated(String menuId) {

        // 1 - Récupère les MealSlots du menu
        List<Object> mealSlots = menuServiceClient
                .getMealSlotsByMenuId(UUID.fromString(menuId))
                .getBody();

        // 2 - Crée la liste de courses
        ShoppingList shoppingList = ShoppingList.builder()
                .menuId(UUID.fromString(menuId))
                .status(ShoppingListStatus.PENDING)
                .build();

        ShoppingList savedList = shoppingListService.createShoppingList(shoppingList);

        // 3 - Pour chaque MealSlot récupère les ingrédients
        if (mealSlots != null) {
            mealSlots.forEach(mealSlot -> {
                // Récupère les ingrédients de la recette
                List<Object> ingredients = recipeServiceClient
                        .getIngredientsByRecipeId(UUID.randomUUID())
                        .getBody();

                // 4 - Crée un ShoppingItem pour chaque ingrédient
                if (ingredients != null) {
                    ingredients.forEach(ingredient -> {
                        ShoppingItem item = ShoppingItem.builder()
                                .shoppingListId(savedList.getId())
                                .ingredientName(ingredient.toString())
                                .isChecked(false)
                                .build();
                        shoppingItemService.createShoppingItem(item);
                    });
                }
            });
        }
    }
}