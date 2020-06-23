package com.techelevator.dao;

import com.techelevator.entity.Meal;

import java.util.List;

public interface MealDao {
    void saveMeal(Meal meal, long userId);

    List<Meal> getAllMeals();

    List<Meal> addRecipeToMeal();

    void insertToMealRecipe(long recipeId, long mealId);

    List<Meal> getMealById(Long mealId);

    List<Meal> getMealsByMealPlanId(Long mealPlanId);

    List<Meal> getAllMealIds(Long mealId);

    List<Meal> getUserMeals(Long userId);


}