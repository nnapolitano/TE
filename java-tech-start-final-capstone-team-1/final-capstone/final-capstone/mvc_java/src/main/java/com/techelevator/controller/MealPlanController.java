package com.techelevator.controller;

import com.techelevator.dao.MealPlanDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.entity.MealPlan;
import com.techelevator.entity.User;
import com.techelevator.security.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.techelevator.security.AuthorizationFilter.LOGGED_USER;

@Controller
public class MealPlanController {

    @Autowired
    private MealPlanDAO mealPlanDao;
    private MealPlan mealPlan;

    @Autowired
    private UserDAO userDAO;


    @Autowired
    public MealPlanController(MealPlanDAO mealPlanDao) {
        this.mealPlanDao = mealPlanDao;
    }


    @RequestMapping(value = "/newMealPlan", method = RequestMethod.GET)
    public String create() {
        return "mealplan/newMealPlan";
    }

    @RequestMapping(path = "/newMealPlan", method = RequestMethod.POST)
    public String createMealPlan(HttpSession session, @RequestParam String mealPlanDescription, @RequestParam String date) {

        User user = (User) session.getAttribute(AuthorizationFilter.LOGGED_USER);

        mealPlan = new MealPlan(user.getGetUserName(), mealPlanDescription, date);

        mealPlanDao.saveMealPlan(mealPlan);


        session.setAttribute("mealPlans", mealPlan);

        return "redirect:saveMeal";
    }


    @RequestMapping(value = "/viewAllPlans", method = RequestMethod.GET)
    public String showAllMealPlans(ModelMap modelHolder) {
        List<MealPlan> plans;
        plans = mealPlanDao.getAllMealPlans();
        modelHolder.put("plans", plans);
        return "mealplan/viewAllPlans";
    }


    @RequestMapping(value = "/viewMyMealPlans", method = RequestMethod.GET)
    public String showMyMealPlans(HttpServletRequest httpRequest, ModelMap modelHolder) {
        User user = (User) httpRequest.getSession().getAttribute(LOGGED_USER);
        List<MealPlan> plans;
        plans = mealPlanDao.getAllMealPlansByUserId(user.getId());
        modelHolder.put("plans", plans);
        return "mealplan/viewAllPlans";

    }


    @RequestMapping(path = "/addMealToMealPlan", method = RequestMethod.GET)
    public String displayAddRecipeToMeal(@RequestParam Long recipeId, HttpSession session) {
        MealPlan mealPlan = (MealPlan) session.getAttribute("plans");
        return "redirect:viewAllPlans";
    }


}



