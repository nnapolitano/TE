package com.techelevator.entity;

import com.techelevator.model.RecipeType;

import java.util.List;
import java.util.Objects;

public class Recipe {

    private long recipeId;
    private String mealTitle;
    private List<String> ingredients;
    private int prepTime;
    private int cookTime;
    private List<String> instructions;
    private List<RecipeType> recipeTypeList;
    private List<Recipe> recipeList;


    public Recipe() {

    }

    public Recipe(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public Recipe(String mealTitle, List<String> ingredients, int prepTime, int cookTime, List<String> instructions,
                  List<RecipeType> recipeTypeList) {
        this(0L, mealTitle, ingredients, prepTime, cookTime, instructions,
                recipeTypeList);
    }

    /**
     * @param recipeId       is the identifier for the recipe, aka primary key
     * @param recipeTypeList this is the types of meals (vegan, keto etc)
     * @param mealTitle      this is the name of the recipe
     * @param ingredients    this is the list of ingredients for the recipe
     * @param prepTime       this is how long the prep time is in minutes
     * @param cookTime       this is how long to cook in minutes
     * @param instructions   these are the step by step instructions
     */


    public Recipe(long recipeId, String mealTitle, List<String> ingredients, int prepTime, int cookTime, List<String> instructions,
                  List<RecipeType> recipeTypeList) {
        this.recipeId = recipeId;
        this.mealTitle = mealTitle;
        this.ingredients = ingredients;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.instructions = instructions;
        this.recipeTypeList = recipeTypeList;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }

    public String getMealTitle() {
        return mealTitle;
    }

    public void setMealTitle(String mealTitle) {
        this.mealTitle = mealTitle;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    public int getCookTime() {
        return cookTime;
    }

    public void setCookTime(int cookTime) {
        this.cookTime = cookTime;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public List<RecipeType> getRecipeTypeList() {
        return recipeTypeList;
    }

    public void setRecipeTypeList(List<RecipeType> recipeTypeList) {
        this.recipeTypeList = recipeTypeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return recipeId == recipe.recipeId &&
                prepTime == recipe.prepTime &&
                cookTime == recipe.cookTime &&
                Objects.equals(mealTitle, recipe.mealTitle) &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(instructions, recipe.instructions) &&
                Objects.equals(recipeTypeList, recipe.recipeTypeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, mealTitle, ingredients, prepTime, cookTime, instructions, recipeTypeList);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "recipeId=" + recipeId +
                ", mealTitle='" + mealTitle + '\'' +
                ", ingredients=" + ingredients +
                ", prepTime=" + prepTime +
                ", cookTime=" + cookTime +
                ", instructions=" + instructions +
                ", recipeTypeList=" + recipeTypeList +
                '}';
    }
}