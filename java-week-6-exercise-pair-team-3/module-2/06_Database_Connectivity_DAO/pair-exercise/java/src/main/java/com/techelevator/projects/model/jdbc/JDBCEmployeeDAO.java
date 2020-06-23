package com.techelevator.projects.model.jdbc;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import java.time.LocalDate;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCEmployeeDAO implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCEmployeeDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Employee> getAllEmployees() {
        String sqlGetAllEmployees =
                "SELECT *" +
                        " FROM employee";
        List<Employee> employees = new ArrayList<>();
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllEmployees);
        while (results.next()) {
            employees.add(mapRowToEmployee(results));
        }
        return employees;
    }

    @Override
    public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {

        String sqlSearchEmployeesByName =
                "SELECT *" +
                        " FROM employee " +
                        " WHERE first_name = ?" + " AND last_name = ?";

        List<Employee> employees = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchEmployeesByName, firstNameSearch, lastNameSearch);

        while (results.next()) {
            employees.add(mapRowToEmployee(results));
        }

        return employees;
    }

    @Override
    public List<Employee> getEmployeesByDepartmentId(long id) {
        String sqlGetEmployeesByDepartmentId =
                "SELECT *" +
                        " FROM employee " +
                        " WHERE department_id = ?";

        List<Employee> employees = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByDepartmentId, id);

        while (results.next()) {
            employees.add(mapRowToEmployee(results));
        }

        return employees;
    }

    @Override
    public List<Employee> getEmployeesWithoutProjects() {
        String sqlGetEmployeesWithoutProjects =
                "SELECT *" +
                        " FROM employee" +
                        " LEFT JOIN project_employee" +
                        " ON employee.employee_id = project_employee.employee_id" +
                        " WHERE project_id is NULL";

        List<Employee> employees = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesWithoutProjects);

        while (results.next()) {
            employees.add(mapRowToEmployee(results));
        }
        return employees;
    }

    @Override
    public List<Employee> getEmployeesByProjectId(Long projectId) {
        String sqlGetEmployeesByProjectId =
                "SELECT *" +
                        " FROM employee" +
                        " JOIN project_employee" +
                        " ON employee.employee_id = project_employee.employee_id" +
                        " WHERE project_id = ?";

        List<Employee> employees = new ArrayList<>();

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetEmployeesByProjectId, projectId);

        while (results.next()) {
            employees.add(mapRowToEmployee(results));
        }
        return employees;
    }

    @Override
    public void changeEmployeeDepartment(Long employeeId, Long departmentId) {

        Employee employeeToUpdate = new Employee();

        employeeToUpdate.setDepartmentId(departmentId);
        try {
            String sqlChangeEmployeeDepartment =
                    "UPDATE employee" + " SET department_id = (?)" + " WHERE employee_id = (?)";
            jdbcTemplate.update(sqlChangeEmployeeDepartment, departmentId, employeeId);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

    }


    private long getNextEmpId() throws com.techelevator.exceptions.DataAccessException {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_employee_id')");
        if (nextIdResult.next()) {
            return nextIdResult.getLong(1);
        } else {
            throw new com.techelevator.exceptions.DataAccessException("blah");
        }

    }

    private Employee mapRowToEmployee(SqlRowSet results) {
        return new Employee(
                results.getLong("employee_id"),
                results.getLong("department_id"),
                results.getString("first_name"),
                results.getString("last_name"),
                results.getDate("birth_date").toLocalDate(),
                results.getString("gender").charAt(0),
                results.getDate("hire_date").toLocalDate());
    }

}
