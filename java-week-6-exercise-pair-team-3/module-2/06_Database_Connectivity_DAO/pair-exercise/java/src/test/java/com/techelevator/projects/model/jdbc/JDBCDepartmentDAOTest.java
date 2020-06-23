package com.techelevator.projects.model.jdbc;

import com.techelevator.projects.model.Department;
import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class JDBCDepartmentDAOTest {

    private static final Department TEST_DEPT = new Department((long) 99, "testing dept");

    private static SingleConnectionDataSource dataSource;
    private JDBCDepartmentDAO dao;

    @BeforeClass
    public static void setupDataSource(){
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/projectorganizer");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }

    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }


    @Before
    public void setUp() {
        String sqlInsertDept = "INSERT INTO department (department_id, name) VALUES (99,'testing dept')";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertDept);
        dao = new JDBCDepartmentDAO(dataSource);
    }

    @After
    public void rollback() throws SQLException{
        dataSource.getConnection().rollback();

    }

    @Test
    public void getAllDepartments() {
        Department one = new Department((long) 90, "testing dept 1");
        Department two = new Department((long) 95, "testing dept 2");
        Department three = new Department((long) 99, "testing dept 3");
        dao.createDepartment(one);
        dao.createDepartment(two);
        dao.createDepartment(three);

        List<Department> results= dao.getAllDepartments();

        assertNotNull(results);
        assertEquals(3, results.size()  );
    }

    @Test
    public void searchDepartmentsByName() {
        Department actual = new Department((long) 99, "testing dept");
        dao.saveDepartment(actual);
        List<Department> results= dao.searchDepartmentsByName("testing dept");
        assertNotNull(results);
        assertEquals("Department{id=99, name='testing dept'}", results.get(0).toString() );
    }

    @Test
    public void saveDepartment() {
    }

    @Test
    public void createDepartment() {
    }

    @Test
    public void getDepartmentById() {
    }
}