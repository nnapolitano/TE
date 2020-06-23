package com.techelevator.dao;

import com.techelevator.entity.Recipe;
import com.techelevator.model.RecipeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class JDBCRecipeDAO implements RecipeDAO {

    private JdbcTemplate jdbcTemplate;
    private RecipeType rt;

    @Autowired
    public JDBCRecipeDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JDBCRecipeDAO() {
    }

    @Override
    public void saveRecipe(long mealTypeId, String meal_tags, String meal_title, List<String> ingredients, int preptime, int cooktime, List<String> instructions) {

    }


    @Override
    public List<Recipe> getRecipeByID() {
        return null;
    }


    @Override
    public List<Recipe> getAllRecipe() {
        List<Recipe> allRecipes = new ArrayList<>();
        String sqlSelectAllReviews = "SELECT * FROM recipe";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllReviews);
        while (results.next()) {
            allRecipes.add(mapRowSetRecipe(results));
        }

        return allRecipes;
    }

    @Override
    public List<Recipe> getRecipeByID(int mealId) {
        List<Recipe> recipes = new ArrayList<>();
        String findRecipeById = "SELECT * FROM recipe WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findRecipeById, mealId);
        while (results.next()) {
            Recipe recipe = mapRowSetRecipe(results);
            recipes.add(recipe);

        }
        return recipes;
    }


    @Override
    public List<Recipe> getRecipeByID(long recipe_id) {
        List<Recipe> foundRecipe = new ArrayList<>();
        String findRecipeById = "SELECT * FROM recipe WHERE recipe_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findRecipeById, recipe_id);
        while (results.next()) {
            Recipe recipe = mapRowSetRecipe(results);
            foundRecipe.add(recipe);

        }
        return foundRecipe;
    }

    @Override
    public List<Recipe> getAllRecipeIds(Long recipe_id) {
        List<Recipe> findId = new ArrayList<>();
        String findIds = "SELECT recipe_id FROM recipe";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findIds, recipe_id);
        while (results.next()) {
            findId.add(mapRowSetRecipe(results));
        }

        return findId;
    }


    private Recipe mapRowSetRecipe(SqlRowSet results) {
        Recipe recipe = new Recipe();
        recipe.setRecipeId(results.getInt("recipe_id"));
        recipe.setMealTitle(results.getString("meal_title"));

        List<String> ingredients = (Arrays.asList(results.getString("ingredients")));
        recipe.setIngredients(ingredients);
        recipe.setPrepTime(results.getInt("preptime"));
        recipe.setCookTime(results.getInt("cooktime"));

        List<String> instructions = (Arrays.asList(results.getString("instructions")));
        recipe.setInstructions(instructions);

        return recipe;
    }


    private long getNextMealId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('app_user_id_seq')");
        Long id = null;

        if (nextIdResult.next()) {
            return nextIdResult.getLong(1);
        }
        return id;
    }

    @Override
    public void saveRecipe(Recipe recipe, long userId) {
        recipe.setRecipeId(getRecipeId());
        String sqlInsertNewRecipe = "INSERT INTO recipe(" +
                "recipe_id, " +
                "user_id, " +
                "meal_title, " +
                "ingredients, " +
                "preptime, " +
                "cooktime, " +
                "instructions) " +
                "VALUES (?,?,?,?,?,?,?)";
        jdbcTemplate.update(sqlInsertNewRecipe,
                recipe.getRecipeId(),
                userId,
                recipe.getMealTitle(),
                createTokenStr(recipe.getIngredients()),
                recipe.getPrepTime(),
                recipe.getCookTime(),
                createTokenStr(recipe.getInstructions()));
    }


    public Recipe modifyRecipe(Recipe recipe) {

        String mealTitle = "";

        String ingredients = "";
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            if (i == 0) {
                ingredients = ingredients + recipe.getIngredients().get(0);
            } else {
                ingredients = ingredients + "," + recipe.getIngredients().get(i);
            }
        }

        String instructions = "";
        for (int i = 0; i < recipe.getInstructions().size(); i++) {
            if (i == 0) {
                instructions = instructions + recipe.getInstructions().get(0);
            } else {
                instructions = instructions + "," + recipe.getInstructions().get(i);
            }
        }

        String sqlUpdateRecipe = "UPDATE recipe SET meal_title = ?, ingredients = ?, instructions = ? WHERE recipe_id= ?";
        jdbcTemplate.update(sqlUpdateRecipe, mealTitle, instructions, ingredients, recipe.getRecipeId());
        return recipe;
    }


    @Override
    public Recipe saveRecipe(Recipe recipe) {
        return recipe;
    }


    private void insertRecipeType(Recipe recipe) {
        String sqlInsertNewRecipeType = "INSERT INTO mealtype_recipe_id(meal_type, recipe_id) VALUES (?,?)";
        for (RecipeType rt : recipe.getRecipeTypeList()) {

            jdbcTemplate.update(sqlInsertNewRecipeType, rt.ordinal(), recipe.getRecipeId());
        }
    }

    private long getRecipeId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_recipe_id')");
        Long id = null;

        if (nextIdResult.next()) {
            return nextIdResult.getLong(1);
        }
        return id;
    }


    private String createTokenStr(List<String> list) {
        String tokenStr = "";
        if (list == null) {
            return tokenStr;
        }
        for (String temp : list) {
            if (tokenStr.length() > 0) {
                tokenStr = tokenStr + ",";
            }
            tokenStr = tokenStr + temp;
        }
        return tokenStr;
    }

    public Recipe modifyRecipe(Long recipeId, String ingredients, String instructions) {

        // replace line breaks with commas to save in database
        String ingredientString = ingredients.replace(" \r\n", ",");
        ingredientString = ingredientString.replace("\r\n ", ",");
        ingredientString = ingredientString.replace("\r\n", ",");
        String instructionString = instructions.replace(" \r\n", ",");
        instructionString = instructionString.replace("\r\n ", ",");
        instructionString = instructionString.replace("\r\n", ",");

        // send update to database
        String sqlUpdateRecipe = "UPDATE recipe SET ingredients=?, instructions=? WHERE recipe_id=?";
        jdbcTemplate.update(sqlUpdateRecipe, ingredientString, instructionString, recipeId);

        // return new updated recipe
        return getRecipeByID(recipeId).get(0);
    }

    @Override
    public List<Recipe> getUserRecipes(long recipe_id, long mealId, Long id) {
        List<Recipe> userRecipes = new ArrayList<>();
        String findRecipeFromUser = "SELECT * FROM recipe" +
                " JOIN recipe_meal ON recipe.recipe_id = ? AND recipe_meal.meal_id = ?" +
                " JOIN meal_meal_plan ON meal_meal_plan.meal_id = recipe_meal.meal_id" +
                " JOIN meal_plan on meal_plan.meal_plan_id = meal_meal_plan.meal_plan_id" +
                " JOIN app_user ON meal_plan.user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findRecipeFromUser, recipe_id, mealId, id);
        while (results.next()) {
            userRecipes.add(mapRowSetRecipe(results));
        }
        return userRecipes;
    }

    @Override
    public List<Recipe> getUserRecipes(Long userId) {
        List<Recipe> userRecipes = new ArrayList<>();
        String findRecipeFromUser = "SELECT * FROM recipe WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findRecipeFromUser, userId);
        while (results.next()) {
            userRecipes.add(mapRowSetRecipe(results));
        }
        return userRecipes;
    }


}

