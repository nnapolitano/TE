package com.techelevator.controller;

import com.techelevator.dao.MealDao;
import com.techelevator.dao.MealPlanDAO;
import com.techelevator.entity.Meal;
import com.techelevator.entity.MealPlan;
import com.techelevator.entity.Recipe;
import com.techelevator.entity.User;
import com.techelevator.security.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MealController {

    @Autowired
    private MealDao mealDao;

    private Meal meal;

    @Autowired
    private MealPlanDAO mealPlanDAO;

    private Recipe recipe;


    @RequestMapping(value = "/saveMeal", method = RequestMethod.GET)
    public String create(HttpSession session) {

        User user = (User) session.getAttribute(AuthorizationFilter.LOGGED_USER);

        List<MealPlan> mealPlans;
        if (user == null) {
            mealPlans = mealPlanDAO.getAllMealPlans();
        } else {
            mealPlans = mealPlanDAO.getAllMealPlansByUserId(user.getId());
        }

        session.setAttribute("mealPlans", mealPlans);
        return "meal/saveMealForm";
    }


    @RequestMapping(value = "/saveMeal", method = RequestMethod.POST)
    public String create(ModelMap modelHolder,
                         HttpSession session,
                         @RequestParam String mealDescription,
                         @RequestParam Long mealPlanId) {

        User user = (User) session.getAttribute(AuthorizationFilter.LOGGED_USER);


        meal = new Meal(mealDescription);

        if (user == null) {
            mealDao.saveMeal(meal, 0);
        } else {
            mealDao.saveMeal(meal, user.getId());
        }


        mealPlanDAO.insertMealIdToMealMealPlan(mealPlanId, meal.getMealId());

        List<Meal> userMeals;
        if (user == null) {
            userMeals = mealDao.getUserMeals((long) 0);
        } else {
            userMeals = mealDao.getUserMeals(user.getId());
        }

        modelHolder.put("userMeals", userMeals);

        return "meal/viewUserMeals";

    }

    @RequestMapping(value = "/viewAllMeals", method = RequestMethod.GET)
    //this gets meals when you go from the save meal form
    public String showReviewsMade(ModelMap modelHolder, @RequestParam Long mealPlanId) {

        List<Meal> meals = new ArrayList<>();
        if (mealPlanId != null) {
            // meals = mealDao.getMealsByMealPlanId(mealPlanId);
        } else {
            meals = mealDao.getAllMeals();
        }
        modelHolder.put("meals", meals);

        return "meal/viewMeal";
    }

    @RequestMapping(value = "/viewAllMealsFromHome", method = RequestMethod.GET)
    public String showMealsForNoneUser(ModelMap modelHolder) {
        List<Meal> mealsAsNonUser = mealDao.getAllMeals();
        modelHolder.put("mealsAsNonUser", mealsAsNonUser);
        return "meal/viewAllMeal";
    }


    @RequestMapping(value = "/viewMealsInAMealPlan", method = RequestMethod.GET)
    public String showUserRecipes(ModelMap modelHolder, @RequestParam Long mealPlanId) {
        List<Meal> userMeals = mealDao.getMealsByMealPlanId(mealPlanId);
        modelHolder.put("userMeals", userMeals);
        return "meal/viewUserMeals";
    }


    @RequestMapping(value = "/viewUserMeals", method = RequestMethod.GET)
    public String showUserMeals(ModelMap modelHolder, HttpSession session) {

        User user = (User) session.getAttribute(AuthorizationFilter.LOGGED_USER);

        List<Meal> userMeals;
        if (user == null) {
            userMeals = mealDao.getUserMeals((long) 0);
        } else {
            userMeals = mealDao.getUserMeals(user.getId());
        }

        modelHolder.put("userMeals", userMeals);

        return "meal/viewUserMeals";
    }


}
