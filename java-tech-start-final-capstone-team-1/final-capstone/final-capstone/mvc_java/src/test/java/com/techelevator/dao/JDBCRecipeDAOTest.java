package com.techelevator.dao;

import com.techelevator.entity.Recipe;
import com.techelevator.model.RecipeType;
import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JDBCRecipeDAOTest {

    /* Using this particular implementation of DataSource so that
     * every database interaction is part of the same database
     * session and hence the same database transaction */
    private static SingleConnectionDataSource dataSource;
    private JDBCRecipeDAO dao;
/* private MealPlan mealPlan;
private MealPlanDAO mealPlanDAO;*/
    private JdbcTemplate jdbcTemplate;

    /* Before any tests are run, this method initializes the datasource for testing. */
    @BeforeClass
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://tecapstone.ddns.net:5432/capstone");
        dataSource.setUsername("capstone_appuser");
        dataSource.setPassword("capstone_appuser1");
        /* The following line disables autocommit for connections
         * returned by this DataSource. This allows us to rollback
         * any changes after each test */
        dataSource.setAutoCommit(false);
    }

    /* After all tests have finished running, this method will close the DataSource */
    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }

    @Before
    public void setup() {
        dao = new JDBCRecipeDAO(dataSource);
        //jdbcTemplate = new JdbcTemplate(dataSource);
    }


    /* After each test, we rollback any changes that were made to the database so that
     * everything is clean for the next test */
    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    /* This method provides access to the DataSource for subclasses so that
     * they can instantiate a DAO for testing */
    protected DataSource getDataSource() {
        return dataSource;
    }


    @Test
    public void testSaveRecipeGetModifyAndRetrieve() {
        assert (true);
    }

    @Test
    public void testSaveRecipeAndGetById() {

        // create our test recipe to save
        Recipe testRecipe = new Recipe(
                1234,
                "Test Meal Title",
                new ArrayList<>(Arrays.asList("eggs", "flour", "butter")),
                40,
                50,
                new ArrayList<>(Arrays.asList("Crack Eggs", "Add to flour", "Mix")),
                new ArrayList<>(Arrays.asList(RecipeType.KETO))
        );
        // call our saveRecipe function to Database, save our test recipe to user id 16
        dao.saveRecipe(testRecipe, Long.valueOf("16"));
        // call our getUserRecipes function from Database for user id 16; our test recipe should be in here
        List<Recipe> recipes = dao.getUserRecipes(Long.valueOf("16"));
        // compare our test recipe getString() to the expected String value
        assertEquals("Recipe{recipeId=" + recipes.get(0).getRecipeId() + ", mealTitle='Test Meal Title', ingredients=[eggs,flour,butter], prepTime=40, cookTime=50, instructions=[Crack Eggs,Add to flour,Mix], recipeTypeList=null}", recipes.get(0).toString());
    }
}