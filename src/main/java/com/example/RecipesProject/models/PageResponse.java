package com.example.RecipesProject.models;



import java.util.List;

public class PageResponse {
private int page;
private int limit;
private List<Recipedata> data;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public List<Recipedata> getData() {

        return data;
    }

    public void setData(List<Recipedata> data) {

        this.data = data;
    }


}
