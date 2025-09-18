package com.example.RecipesProject.models;

import jakarta.persistence.*;
import lombok.*;

@Entity

@Table(name="recipedata")
public class Recipedata {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Float rating;
    private Integer prep_time;
    private Integer cook_time;
    private Integer total_time;
    private  String serves;
    private String cuisine;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String nutrients;




    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }


    public String getcuisine(){
        return cuisine;
    }
    public void setCuisine(String cuisine) {
        this.cuisine=cuisine;
    }


    public String gettitle(){
        return title;
    }
    public void setTitle(String title) {
      this.title=title;
    }


    public Float getRating(){
        return rating;
    }
    public void setRating(Float rating) {
         this.rating=rating;
    }


    public Integer getPreptime(){
        return prep_time;
    }
    public void setPreptime(Integer prep_time) {
         this.prep_time=prep_time;
    }


    public Integer getCooktime(){
        return cook_time;
    }
    public void setCooktime(Integer cook_time) {
       this.cook_time=cook_time;
    }


    public Integer getTotaltime(){
        return total_time;
    }
    public void setTotaltime(Integer total_time) {
       this.total_time=total_time;
    }


    public String getDescription(){
        return description;
    }
    public void setDescription(String description) {
        this.description=description;
    }


    public String getNutrients(){
        return nutrients;
    }
    public void setNutrients(String nutrients) {
        this.nutrients=nutrients;
    }


    public String getServes(){
        return serves;
    }
    public void setServes(String serves) {
        this.serves=serves;
    }
}
