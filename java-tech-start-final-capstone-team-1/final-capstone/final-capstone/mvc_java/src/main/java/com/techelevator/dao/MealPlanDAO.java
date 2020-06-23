package com.techelevator.dao;

import com.techelevator.entity.MealPlan;

import java.util.List;

public interface MealPlanDAO {

    MealPlan saveMealPlan(MealPlan mealPlan);

    List<MealPlan> getAllMealPlansByUserId(Long userId);

    MealPlan getMealPlan(Long mealPlanId);

    void changeUserMealPlan(Long mealPlanId, Long userId);

    void setMealPlanById(MealPlan mealPlanById);

    void deleteMealPlan(Long mealPlanId);

    List<MealPlan> getAllMealPlans();

    void insertMealIdToMealMealPlan(long mealPlanId, long mealId);

    //List<MealPlan> getAllMealPlansByUserId(Object userId);

}