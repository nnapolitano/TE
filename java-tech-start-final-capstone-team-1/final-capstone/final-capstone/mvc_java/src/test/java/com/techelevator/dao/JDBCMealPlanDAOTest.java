package com.techelevator.dao;

import org.junit.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class JDBCMealPlanDAOTest {

    /* Using this particular implementation of DataSource so that
     * every database interaction is part of the same database
     * session and hence the same database transaction */
    private static SingleConnectionDataSource dataSource;
    private JDBCMealPlanDAO dao;

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
        dao = new JDBCMealPlanDAO(dataSource);
        jdbcTemplate = new JdbcTemplate(dataSource);
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
    public void saveMealPlan() {


    }
}