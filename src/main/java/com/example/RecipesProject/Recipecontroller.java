package com.example.RecipesProject;
import com.example.RecipesProject.models.PageResponse;
import com.example.RecipesProject.models.Recipedata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")

public class Recipecontroller {
    @Autowired
    private Recipeservice recipeservice;

    @PostMapping("/loadjsondata")
    public String loadjsondata() throws Exception {
        recipeservice.loadData();
        return ("Loaded Successfully");
    }


    @GetMapping("get")
    public PageResponse sortByRating(@RequestParam int page, @RequestParam int size) {
        return recipeservice.sortByRating(page, size);
    }

    @GetMapping("search")
    public List<Recipedata> search(@RequestParam String calories, @RequestParam String title, @RequestParam String rating) {
        return recipeservice.search(calories, title, rating);
    }
}