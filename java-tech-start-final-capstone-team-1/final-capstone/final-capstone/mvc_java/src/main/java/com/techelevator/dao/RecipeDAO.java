package com.techelevator.dao;

import com.techelevator.entity.Recipe;

import java.util.List;

public interface RecipeDAO {

    List<Recipe> getAllRecipe();

    void saveRecipe(long recipe_id, String meal_tags, String meal_title, List<String> ingredients, int preptime, int cooktime, List<String> instructions);

    List<Recipe> getRecipeByID(long recipe_id);

    List<Recipe> getAllRecipeIds(Long recipe_id);


    List<Recipe> getRecipeByID(int mealId);

    List<Recipe> getRecipeByID();

    Recipe modifyRecipe(Recipe recipe);

    Recipe saveRecipe(Recipe recipe);

    void saveRecipe(Recipe recipe, long userId);

    Recipe modifyRecipe(Long recipeId, String ingredients, String instructions);

    List<Recipe> getUserRecipes(long recipe_id, long mealId, Long id);

    List<Recipe> getUserRecipes(Long userId);


}


