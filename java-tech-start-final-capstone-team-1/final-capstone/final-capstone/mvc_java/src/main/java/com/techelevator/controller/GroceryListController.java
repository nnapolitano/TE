package com.techelevator.controller;


import com.techelevator.dao.*;
import com.techelevator.entity.Meal;
import com.techelevator.entity.MealPlan;
import com.techelevator.entity.Recipe;
import com.techelevator.entity.User;
import com.techelevator.model.RecipeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.techelevator.security.AuthorizationFilter.LOGGED_USER;

@Controller
public class GroceryListController {

    @Autowired
    UserDAO userDAO;
    @Autowired
    private RecipeDAO recipeDAO;
    private Recipe recipe;
    @Autowired
    private MealDao mealDao;
    private Meal meal;
    private User user;
    private Object ResponseEntity;
    private RecipeType recipeType;

    @Autowired
    private MealPlanDAO mealPlanDao;
    private MealPlan mealPlan;

    @Autowired
    private GroceryListDAO groceryListDAO;


    @RequestMapping(value = "/groceryList", method = RequestMethod.GET)
    public String showGroceryList(HttpServletRequest httpRequest, ModelMap modelHolder) {

        User user = (User) httpRequest.getSession().getAttribute(LOGGED_USER);

        List<String> groceries;

        groceries = groceryListDAO.getAllIngredientsByUserId(user.getId());


        modelHolder.put("groceries", groceries);

        return "mealplan/viewMealPlanGrocery";
    }

}
