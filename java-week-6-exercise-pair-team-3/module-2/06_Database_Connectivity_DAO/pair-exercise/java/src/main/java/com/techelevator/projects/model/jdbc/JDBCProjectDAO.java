package com.techelevator.projects.model.jdbc;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCProjectDAO implements ProjectDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCProjectDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Project> getAllActiveProjects() {

		String sqlFindAllActiveProjects =
				"SELECT project_id, name, from_date, to_date" +
						" FROM project " +
						" WHERE from_date IS NOT NULL" +
						" AND from_date < NOW()" +
						" AND (to_date IS NULL or to_date > NOW());";

		ArrayList<Project> project = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllActiveProjects);
		while (results.next()) {
			project.add(mapRowToProject(results));
		}
		return project;
	}

    @Override
    public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		try {
			String removeEmployeeFromProject =
					"DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
			jdbcTemplate.update(removeEmployeeFromProject, projectId, employeeId);
		}catch (Exception e) {
			System.out.println("An Error occurred: " + e.getMessage());
		}
    }

    @Override
    public void addEmployeeToProject(Long projectId, Long employeeId) {
    	try {
			String addEmployeeToProject = "INSERT INTO project_employee (project_id, employee_id) VALUES (?,?)";
			jdbcTemplate.update(addEmployeeToProject, projectId, employeeId);
		}catch (Exception e) {
			System.out.println("An Error occurred: " + e.getMessage());
		}
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project(
				results.getLong("project_id"),
				results.getString("name"));
		Date fromDate = results.getDate("from_date");
		if (fromDate != null) {
			project.setStartDate(fromDate.toLocalDate());
		}
		Date toDate = results.getDate("to_date");
		if (toDate != null) {
			project.setEndDate(toDate.toLocalDate());
		}
		return project;
	}
	}
