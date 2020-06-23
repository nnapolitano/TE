package com.techelevator.dao;

import com.techelevator.entity.MealPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCMealPlanDAO implements MealPlanDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JDBCMealPlanDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public MealPlan saveMealPlan(MealPlan mealPlan) {

        mealPlan.setMealPlanId(getNextMealPlanId());
        mealPlan.setUserId(getUserIdByName(mealPlan.getUserName()));

        String sqlInsertMealPlan = "INSERT INTO meal_plan (meal_plan_id, user_id, mealplan_description, meal_date)" +
                " VALUES (?,?,?,TO_DATE(?, 'MM/DD/YYYY')); ";
        jdbcTemplate.update(sqlInsertMealPlan, mealPlan.getMealPlanId(),
                mealPlan.getUserId(),
                mealPlan.getMealPlanDescription(),
                mealPlan.getDate());
        return mealPlan;
    }

    public void insertMealIdToMealMealPlan(long mealPlanId, long mealId) {

        String sqlInsertNewMealId = "INSERT INTO meal_meal_plan(meal_plan_id, meal_id) VALUES (?,?)";

        jdbcTemplate.update(sqlInsertNewMealId, mealPlanId, mealId);
    }


    private Long getNextMealPlanId() {
        String sqlSelectNextId = "SELECT NEXTVAL('seq_meal_plan_meal_plan_id')";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
        Long id = null;
        if (results.next()) {
            id = results.getLong(1);
        } else {
            throw new RuntimeException("An error occurred");
        }
        return id;
    }


    @Override
    public List<MealPlan> getAllMealPlansByUserId(Long userId) {
        List<MealPlan> mealPlans = new ArrayList<>();
        String findMealPlanByUserId = "SELECT * FROM meal_plan WHERE user_id = ? ORDER BY meal_date DESC";
        SqlRowSet results = jdbcTemplate.queryForRowSet(findMealPlanByUserId, userId);
        while (results.next()) {
            MealPlan mealPlan = mapRowSetToMealPlan(results);
            mealPlans.add(mealPlan);
        }
        return mealPlans;

    }


    @Override
    public MealPlan getMealPlan(Long mealPlanId) {

        String sqlFindMealPlanByMealPlanId =
                "SELECT * " +
                        " FROM meal_plan " +
                        " WHERE meal_plan_id = ?";

        MealPlan mealPlan = null;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindMealPlanByMealPlanId, mealPlanId);
        if (results.next()) {
            mealPlan = mapRowSetToMealPlan(results);
        }
        return mealPlan;
    }


    @Override
    public void changeUserMealPlan(Long mealPlanId, Long userId) {

        String updateMealPlan = "UPDATE meal_plan SET user_id=? WHERE meal_plan_id=?";
        jdbcTemplate.update(updateMealPlan, userId, mealPlanId);

    }


    @Override
    public void deleteMealPlan(Long mealPlanId) {
        String deleteMealPlan = "DELETE FROM meal_plan WHERE meal_plan_id=?";
        jdbcTemplate.update(deleteMealPlan, mealPlanId);

    }

    @Override
    public List<MealPlan> getAllMealPlans() {
        List<MealPlan> allPlans = new ArrayList<>();
        String sqlSelectAllPlans = "SELECT * FROM meal_plan";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPlans);
        while (results.next()) {
            allPlans.add(mapRowSetToMealPlan(results));
        }

        return allPlans;
    }


    @Override
    public void setMealPlanById(MealPlan mealPlan) {
        String updateMealPlan = "UPDATE meal_plan SET mealplan_description=?, meal_date=TO_DATE(?, 'MM/DD/YYYY') WHERE meal_plan_id=?";
        jdbcTemplate.update(updateMealPlan, mealPlan.getMealPlanDescription(), mealPlan.getDate(), mealPlan.getMealPlanId());

    }

    private Long getUserIdByName(String userName) {
        String sqlSelectNextId = "SELECT id FROM app_user where user_Name= ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId, userName);
        return results.next() ? results.getLong("id") : null;// if true populate data otherwise set it to null.
    }

    private MealPlan mapRowSetToMealPlan(SqlRowSet results) {
        MealPlan mealPlan = new MealPlan();
        mealPlan.setMealPlanId(results.getLong("meal_plan_id"));
        mealPlan.setUserId(results.getLong("user_id"));
        mealPlan.setMealPlanDescription(results.getString("mealplan_description"));
        mealPlan.setDate(results.getString("meal_date"));
        return mealPlan;
    }
}
