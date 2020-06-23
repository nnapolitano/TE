package com.techelevator.entity;

import java.util.List;
import java.util.Objects;

public class Meal {

    private Long mealId;

    private String mealDescription;
    private List<Recipe> recipes;
    private List<Meal> allMeals;

    public Meal() {
    }

    public Meal(String mealDescription) {
        this(0L, mealDescription);
    }

    public Meal(Long mealId, String mealDescription) {
        this.mealId = mealId;
        this.mealDescription = mealDescription;
    }

    public Meal(Long mealId, String mealDescription, List<Recipe> recipes) {
        this.mealId = mealId;
        this.mealDescription = mealDescription;
        this.recipes = recipes;
    }

    public Meal(List<Meal> allMeals) {
        this.allMeals = allMeals;
    }

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }


    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealId=" + mealId +
                ", mealDescription='" + mealDescription + '\'' +
                ", recipes=" + recipes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Meal)) return false;
        Meal meal = (Meal) o;
        return Objects.equals(mealId, meal.mealId) &&
                Objects.equals(mealDescription, meal.mealDescription) &&
                Objects.equals(recipes, meal.recipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, mealDescription, recipes);
    }
}