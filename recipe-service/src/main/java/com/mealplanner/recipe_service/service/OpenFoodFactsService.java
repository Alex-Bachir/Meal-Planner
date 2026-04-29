package com.mealplanner.recipe_service.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.mealplanner.recipe_service.client.OpenFoodFactsClient;
import com.mealplanner.recipe_service.model.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenFoodFactsService {

    private final OpenFoodFactsClient openFoodFactsClient;
    private final IngredientService ingredientService;

    public Ingredient getIngredientByBarcode(String barcode) {

        // 1 - Vérifie si l'ingrédient existe déjà en base
        return ingredientService.getIngredientByBarcode(barcode)
                .orElseGet(() -> {

                    // 2 - Si non, appelle Open Food Facts
                    JsonNode product = openFoodFactsClient.getProductByBarcode(barcode);
                    JsonNode productNode = product.get("product");

                    // 3 - Construit l'entité Ingredient
                    Ingredient ingredient = Ingredient.builder()
                            .barcode(barcode)
                            .name(productNode.get("product_name").asText())
                            .imageUrl(productNode.get("image_url").asText())
                            .category(productNode.get("categories").asText())
                            .nutriScore(productNode.get("nutrition_grades").asText())
                            .calories(productNode.get("nutriments").get("energy-kcal_100g").asDouble())
                            .proteins(productNode.get("nutriments").get("proteins_100g").asDouble())
                            .carbohydrates(productNode.get("nutriments").get("carbohydrates_100g").asDouble())
                            .fat(productNode.get("nutriments").get("fat_100g").asDouble())
                            .build();

                    // 4 - Sauvegarde en base et retourne
                    return ingredientService.createIngredient(ingredient);
                });
    }
}