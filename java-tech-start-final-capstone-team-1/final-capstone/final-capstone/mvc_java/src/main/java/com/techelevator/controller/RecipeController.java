package com.techelevator.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.techelevator.dao.MealDao;
import com.techelevator.dao.RecipeDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.entity.Meal;
import com.techelevator.entity.Recipe;
import com.techelevator.entity.User;
import com.techelevator.model.RecipeType;
import com.techelevator.security.AuthorizationFilter;
import com.techelevator.exception.*;


@RestController
@CrossOrigin
@RequestMapping("/")

public class RecipeController {

    private RecipeDAO recipeDAO;
    private Recipe recipe;

    public RecipeController(RecipeDAO recipeDAO) {
        this.recipeDAO = recipeDAO;
    }

//    @GetMapping("/modifyRecipe{id}")
//    public Recipe read(@PathVariable int id) throws RecipeNotFoundException{
//        Recipe recipe = (Recipe) recipeDAO.getRecipeByID(id);
//        if(recipe != null){
//            return recipe;
//             } else {
//            throw new RecipeNotFoundException(id, "Recipe not found!");
//        }
//    }

    //this will show all recipes
    @GetMapping("/viewRecipe")
    public List<Recipe> allRecipes() {
        List<Recipe> recipes = recipeDAO.getAllRecipe();

        return recipes;
    }


    //this will show a recipes
    @GetMapping("/viewRecipe/{id}")
    public List<Recipe> aRecipe(@PathVariable long id) {
        List<Recipe> aRecipe = recipeDAO.getRecipeByID(id);
        return aRecipe;
    }


    @PostMapping("/saveRecipe")
    @ResponseStatus(HttpStatus.CREATED)
    public Recipe create(@RequestBody Recipe recipe) {
        return recipeDAO.saveRecipe(recipe);
    }


    @PutMapping("/modify/{id}")
    public Recipe update(@RequestBody Recipe recipe, @PathVariable long id) {

        recipeDAO.getRecipeByID(id);



        return recipeDAO.modifyRecipe(recipe);
    }




}





