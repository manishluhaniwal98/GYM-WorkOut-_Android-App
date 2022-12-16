package com.app.fitnessandnutrition;

public class User {

    String name;
    String height;
    String weight;
    String gender;
    String email;

    public User() {
        //no-arg constructor
    }

    public User(String name, String height, String weight, String gender, String email) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
