package com.techelevator.entity;

import java.util.List;
import java.util.Objects;

public class MealPlan {

    private Long mealPlanId;
    private Long userId;
    private String userName;
    private String mealPlanDescription;
    private String date;
    private List<Meal> meals;
    private Long mealId;

    public MealPlan() {
    }

    public MealPlan(List<Meal> meals) {
        this.meals = meals;
    }

    public MealPlan(String userName, String mealPlanDescription, String date) {
        this.userName = userName;
        this.mealPlanDescription = mealPlanDescription;
        this.date = date;

    }

    public MealPlan(Long userId, String mealPlanDescription, String date) {
        this.userId = userId;
        this.mealPlanDescription = mealPlanDescription;
        this.date = date;

    }
/* public MealPlan(Long mealPlanId, Long userId, String mealPlanDescription, LocalDate date, List<Meal> meals) {
this.mealPlanId = mealPlanId;
this.userId = userId;
this.mealPlanDescription = mealPlanDescription;
this.date = date;
this.meals = meals;
}*/

    public Long getMealId() {
        return mealId;
    }

    public void setMealId(Long mealId) {
        this.mealId = mealId;
    }

    public Long getMealPlanId() {
        return mealPlanId;
    }

    public void setMealPlanId(Long mealPlanId) {
        this.mealPlanId = mealPlanId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMealPlanDescription() {
        return mealPlanDescription;
    }

    public void setMealPlanDescription(String mealPlanDescription) {
        this.mealPlanDescription = mealPlanDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public List<Meal> getMeals() {
        return meals;
    }

    public List<Meal> setMeals(List<Meal> meals) {
        this.meals = meals;
        return meals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MealPlan)) return false;
        MealPlan mealPlan = (MealPlan) o;
        return Objects.equals(mealPlanId, mealPlan.mealPlanId) &&
                Objects.equals(userId, mealPlan.userId) &&
                Objects.equals(mealPlanDescription, mealPlan.mealPlanDescription) &&
                Objects.equals(date, mealPlan.date) &&
                Objects.equals(meals, mealPlan.meals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealPlanId, userId, mealPlanDescription, date, meals);
    }


    @Override
    public String toString() {
        return "MealPlan{" +
                "mealPlanId=" + mealPlanId +
                ", userName='" + userName + '\'' +
                ", mealPlanDescription='" + mealPlanDescription + '\'' +
                ", date='" + date + '\'' +
                ", meals=" + meals +
                '}';
    }
}