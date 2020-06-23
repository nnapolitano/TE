package com.techelevator.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * The meal plan program implements an application that
 * allows the meal planner user to create and add new meals to the plan.
 *
 * @author Team 1
 */

public class CreateMealPlan {

    private Long mealPlanId;
    private Long userId;
    private String mealPlanDescription;
    private LocalDate date;
    private String day;
    private List<Long> mealId;

    public CreateMealPlan() {
    }

    public CreateMealPlan(Long mealPlanId, Long userId, String mealPlanDescription, LocalDate date, String day, List<Long> mealId) {
        this.mealPlanId = mealPlanId;
        this.userId = userId;
        this.mealPlanDescription = mealPlanDescription;
        this.date = date;
        this.day = day;
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

    public String getMealPlanDescription() {
        return mealPlanDescription;
    }

    public void setMealPlanDescription(String mealPlanDescription) {
        this.mealPlanDescription = mealPlanDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<Long> getMealId() {
        return mealId;
    }

    public void setMealId(List<Long> mealId) {
        this.mealId = mealId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreateMealPlan)) return false;
        CreateMealPlan that = (CreateMealPlan) o;
        return Objects.equals(mealPlanId, that.mealPlanId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(mealPlanDescription, that.mealPlanDescription) &&
                Objects.equals(date, that.date) &&
                Objects.equals(day, that.day) &&
                Objects.equals(mealId, that.mealId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealPlanId, userId, mealPlanDescription, date, day, mealId);
    }

    @Override
    public String toString() {
        return "CreateMealPlan{" +
                "mealPlanId=" + mealPlanId +
                ", userId=" + userId +
                ", mealPlanDescription='" + mealPlanDescription + '\'' +
                ", date=" + date +
                ", day='" + day + '\'' +
                ", mealId=" + mealId +
                '}';
    }
}