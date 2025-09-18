package com.example.RecipesProject;
import com.example.RecipesProject.models.PageResponse;
import com.example.RecipesProject.models.Recipedata;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


@Service
public class Recipeservice {

    @Autowired
    private Reciperepository repository;

    public void loadData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/RecipesProject.json");
        JsonNode root = mapper.readTree(inputStream);

        for (Iterator<Map.Entry<String, JsonNode>> iterator = root.fields(); iterator.hasNext(); ) {
            Map.Entry<String, JsonNode> entry = iterator.next();
            JsonNode node = entry.getValue();

            Recipedata recipe = new Recipedata();
            recipe.setCuisine(node.get("cuisine").asText());
            recipe.setTitle(node.get("title").asText());
            recipe.setRating((float) node.get("rating").asDouble());
            recipe.setPreptime(node.get("prep_time").asInt());
            recipe.setCooktime(node.get("cook_time").isNull() ? null : node.get("cook_time").asInt());
            recipe.setTotaltime(node.get("total_time").asInt());
            recipe.setDescription(node.get("description").asText());
            recipe.setNutrients(node.get("nutrients").toString());
            recipe.setServes(node.get("serves").asText());

            repository.save(recipe);
        }
    }

    public PageResponse sortByRating(int page, int limit) {
        PageResponse response = new PageResponse();
        response.setPage(page);
        response.setLimit(limit);
        List<Recipedata> data = repository.findAllByOrderByRatingDesc();
        response.setData(data.stream().limit(limit).toList());
        return response;
    }

    public List<Recipedata> search(String calories, String title, String rating) {
        List<Recipedata> every = repository.findAll();
        List<Recipedata> newarray = new ArrayList<>();

        for (Recipedata data : every) {
            boolean matches = true;
            String nutrientsJson = data.getNutrients();
            String extract = extractFieldFromJson(nutrientsJson, "calories");
            float first = getreplace(extract);
            if(calories.charAt(0) == '>' && first < getreplace(calories)) {
                matches = false;
            }else if(calories.charAt(0) == '<' && first > getreplace(calories)) {
                matches = false;
            }

            String title1=title.toLowerCase();
            String title3=gettitle(data.gettitle().toLowerCase());
            if (!title3.contains(title1)) {
                matches=false;
            }

            float rating1=data.getRating();
            if (rating.charAt(0) == '>' && rating1 < getreplace(rating)) {
                matches=false;
            } else if (rating.charAt(0) == '<' && rating1 > getreplace(rating)) {
                matches=false;
            }
            if (matches) {
                newarray.add(data);
            }
        }
        return newarray ;
    }

    private String extractFieldFromJson(String json, String key) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(json);
            return jsonNode.get(key).asText();
        } catch (Exception e) {
            return "0";
        }
    }



    private String gettitle(String hello) {

        return hello.replaceAll(" "," ");
    }

    public float getreplace(String let) {

        return Float.parseFloat(let.replaceAll("[^0-9]", ""));
    }
}