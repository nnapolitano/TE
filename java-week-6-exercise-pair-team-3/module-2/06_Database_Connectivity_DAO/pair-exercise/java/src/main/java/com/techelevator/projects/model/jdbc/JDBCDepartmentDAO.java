package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.exceptions.DataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCDepartmentDAO implements DepartmentDAO {


    private JdbcTemplate jdbcTemplate;

    public JDBCDepartmentDAO(DataSource dataSource) {
        try {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Department> getAllDepartments() {
        String sqlGetAllDepartments =
                "SELECT *" +
                        " FROM department";
        List<Department> departments = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllDepartments);
        while (results.next()) {
            departments.add(mapRowToDepartment(results));
        }
        return departments;

    }

    @Override
    public List<Department> searchDepartmentsByName(String nameSearch) {

        String sqlSearchDepartmentsByName =
                "SELECT department_id, name" +
                        " FROM department " +
                        " WHERE name = ?";

        ArrayList<Department> departments = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchDepartmentsByName, nameSearch);
        while (results.next()) {
            departments.add(mapRowToDepartment(results));
        }
        return departments;

    }

    @Override
    public void saveDepartment(Department updatedDepartment) {
        Department departmentToUpdate = new Department(updatedDepartment.getId(), updatedDepartment.getName());

        departmentToUpdate.setName(updatedDepartment.getName());
        try {
            String sqlSaveDepartment =
                    "UPDATE department" + " SET name = (?)" + " WHERE department_id = " + updatedDepartment.getId();
            jdbcTemplate.update(sqlSaveDepartment, updatedDepartment.getName());
        } catch (Exception e) {
            System.out.println("you suck - " + e.getMessage());
        }
    }


    @Override
    public Department createDepartment(Department newDepartment) {

//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        String sqlCreatePerson = "INSERT INTO person(middle_name, last_name, first_name) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sqlCreatePerson, "Stevie", "Ray", "Vaughan");

        Department departmentToAdd = new Department(getNextDeptId(), newDepartment.getName());
        String sqlCreateDepartment =
                "INSERT INTO department(department_id , name)" + " VALUES(?,?) ";
        jdbcTemplate.update(sqlCreateDepartment, getNextDeptId(), newDepartment.getName());
        return departmentToAdd;
    }

    @Override
    public Department getDepartmentById(Long id) {

        String sqlSearchDepartmentsById =
                "SELECT name" +
                        "FROM department " +
                        "WHERE department_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchDepartmentsById);

        Department department = new Department();
        department.getName();


        if (results.next()) {
            return (mapRowToDepartment(results));
        }
        return department;
    }


    private Department mapRowToDepartment(SqlRowSet results) {
        return new Department(
                results.getLong("department_id"),
                results.getString("name")
        );

    }

    private long getNextDeptId() throws DataAccessException {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
        if (nextIdResult.next()) {
            return nextIdResult.getLong(1);
        } else {
            throw new DataAccessException("you suck");
        }
    }
}


