package com.app.fitnessandnutrition;

import java.io.Serializable;

public class Categories implements Serializable {

    private int categoryImg;
    private final String categoryTitle;

    Categories(String categoryTitle){
        this.categoryTitle = categoryTitle;
    }

    Categories(int categoryImg, String categoryTitle){
        this.categoryImg = categoryImg;
        this.categoryTitle = categoryTitle;
    }

    public int getCategoryImg() {
        return categoryImg;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

}
