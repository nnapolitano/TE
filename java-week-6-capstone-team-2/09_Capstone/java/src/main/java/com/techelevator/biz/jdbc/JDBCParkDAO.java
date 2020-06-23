package com.techelevator.biz.jdbc;

import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.biz.ParkDAO;
import com.techelevator.entity.Park;

public class JDBCParkDAO implements ParkDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCParkDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Park> getAllParks() {
        List<Park> parks = new ArrayList<Park>();
        String sqlGetAllParks = "SELECT * FROM park ORDER BY name";
        Park thePark;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllParks);
        while(results.next()) {
            thePark = mapRowToPark(results);
            parks.add(thePark);
        }
        return parks;
    }

    @Override
    public List<Park> getParkById(long id) {
        List<Park> parks = new ArrayList<>();
        String getAllParks = "SELECT * FROM park WHERE park_id = ?";
        Park park;
        SqlRowSet results = jdbcTemplate.queryForRowSet(getAllParks, id);
        while(results.next()) {
            park = mapRowToPark(results);
            parks.add(park);
        }
        return parks;
    }

    public String toString() {
        return "Select a Park for Further Details";
    }


    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();
        park.setParkId(results.getLong("park_id"));
        park.setName(results.getString("name"));
        park.setLocation(results.getString("location"));
        park.setEstablish_date(results.getDate("establish_date").toLocalDate());
        park.setArea(results.getLong("area"));
        park.setVisitors(results.getLong("visitors"));
        park.setDescription(results.getString("description"));

        return park;
    }
}