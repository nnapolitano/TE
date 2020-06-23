package com.techelevator.dao;

import java.util.List;

public interface GroceryListDAO {

    List<String> getAllIngredientsByUserId(Long userId);

}
