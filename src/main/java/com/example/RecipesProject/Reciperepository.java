package com.example.RecipesProject;

import com.example.RecipesProject.models.Recipedata;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


 public interface Reciperepository extends JpaRepository<Recipedata,Long> {

    List<Recipedata> findAllByOrderByRatingDesc() ;

 }
