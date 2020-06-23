package com.techelevator.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCGroceryListDAO implements GroceryListDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCGroceryListDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<String> getAllIngredientsByUserId(Long userId) {
        String sqlSelectAllIngredientsByMealPlanId = "Select recipe.meal_title, recipe.ingredients "
                + "from recipe JOIN recipe_meal "
                + "ON recipe_meal.recipe_id = recipe.recipe_id "
                + "JOIN meal "
                + "ON recipe_meal.meal_id = meal.meal_id "
                + "JOIN meal_meal_plan "
                + "ON meal_meal_plan.meal_id = meal.meal_id "
                + "JOIN meal_plan "
                + "ON meal_meal_plan.meal_plan_id = meal_plan.meal_plan_id "
                + "WHERE meal_plan.user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllIngredientsByMealPlanId, userId);

        List<String> allIngredients = new ArrayList<String>();
        while (results.next()) {

            allIngredients.add(results.getString("ingredients"));
        }
        return allIngredients;
    }

}