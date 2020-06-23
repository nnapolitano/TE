package com.techelevator.dao;

import com.techelevator.entity.Meal;
import com.techelevator.entity.MealPlan;
import com.techelevator.model.RecipeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCMealDao implements MealDao {
    private JdbcTemplate jdbcTemplate;
    private RecipeType rt;

    @Autowired
    public JDBCMealDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveMeal(Meal meal, long userId) {
        meal.setMealId(getMealId());
        String sqlInsertNewMeal = "INSERT INTO meal(" +
                "meal_id, " +
                "user_id, " +
                "meal_description)" +
                "VALUES (?,?,?)";
        jdbcTemplate.update(sqlInsertNewMeal,
                meal.getMealId(),
                userId,
                meal.getMealDescription());
    }

    public List<Meal> getAllMeals() {
        List<Meal> allMeals = new ArrayList<>();
        String sqlSelectAllMeals = "SELECT * FROM meal";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllMeals);
        while (results.next()) {
            allMeals.add(mapRowSetMeal(results));
        }

        return allMeals;
    }



    @Override
    public List<Meal> addRecipeToMeal() {
        return null;
    }

    public void insertToMealRecipe(long recipeId, long mealId) {

        String sqlInsertNewMealId = "INSERT INTO recipe_meal(recipe_id,meal_id) VALUES (?,?)";

        jdbcTemplate.update(sqlInsertNewMealId, recipeId, mealId);
    }


    private Meal mapRowSetMeal(SqlRowSet results) {
        Meal meal = new Meal();
        meal.setMealId(results.getLong("meal_id"));
        meal.setMealDescription(results.getString("meal_description"));

        return meal;
    }

    private long getMealId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_meal_meal_id')");
        Long id = null;

        if (nextIdResult.next()) {
            return nextIdResult.getLong(1);
        }
        return id;
    }

    @Override
    public List<Meal> getMealById(Long mealId) {
        List<Meal> myMeals = new ArrayList<>();
        String findMealById = "SELECT * FROM meal WHERE meal_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findMealById, mealId);
        while (results.next()) {
            myMeals.add(mapRowSetMeal(results));
        }
        return myMeals;

    }


    @Override
    public List<Meal> getMealsByMealPlanId(Long mealPlanId) {

        List<Meal> mealsByMealPlan = new ArrayList<>();
        String findMealIdsByMealPlanId = "SELECT * FROM meal JOIN meal_meal_plan ON meal_plan_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findMealIdsByMealPlanId, mealPlanId);
        while (results.next()) {
            mealsByMealPlan.add(mapRowSetMeal(results));
        }
        return mealsByMealPlan;
    }


    @Override
    public List<Meal> getAllMealIds(Long mealId) {
        List<Meal> findMealId = new ArrayList<>();
        String foundMealIds = "SELECT meal_id FROM meal";
        SqlRowSet results = jdbcTemplate.queryForRowSet(foundMealIds, mealId);
        while (results.next()) {
            findMealId.add(mapRowSetMeal(results));
        }

        return findMealId;
    }


    @Override
    public List<Meal> getUserMeals(Long userId) {
        List<Meal> userMeals = new ArrayList<>();
        String findMealFromUser = "SELECT * FROM meal WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findMealFromUser, userId);
        while (results.next()) {
            userMeals.add(mapRowSetMeal(results));
        }
        return userMeals;
    }

    private Meal mapRowSetToMeal(SqlRowSet results) {

        Meal meal = new Meal();
        meal.setMealId(results.getLong("meal_id"));
        meal.setMealDescription(results.getString("meal_description"));

        return meal;
    }

    private Meal mapRowMealMealPlan(SqlRowSet results) {

        Meal meal = new Meal();
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealPlanId(results.getLong("meal_plan_id"));
        meal.setMealId(results.getLong("meal_id"));

        return meal;
    }


}
