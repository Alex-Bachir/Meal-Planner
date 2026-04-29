package com.mealplanner.recipe_service.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class OpenFoodFactsClient {

    private static final String BASE_URL = "https://world.openfoodfacts.org/api/v2/product/";
    private final RestTemplate restTemplate = new RestTemplate();

    public JsonNode getProductByBarcode(String barcode) {
        String url = BASE_URL + barcode + ".json";
        ResponseEntity<JsonNode> response = restTemplate.getForEntity(url, JsonNode.class);
        return response.getBody();
    }
}