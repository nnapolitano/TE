package com.techelevator.model;
/**
 * these are the different types of recipes, and new diets can be added / removed here
 */
public enum RecipeType {
    VEGETERIAN("Vegetarian"),
    KETO("Keto"),
    GLUTENFREE("Gluten Free"),
    VEGAN("Vegan"),
    NA("Not Applicable");


    private final String description;

    RecipeType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}