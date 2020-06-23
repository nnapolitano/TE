package com.techelevator.biz.jdbc;

import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.entity.Campground;
import com.techelevator.biz.CampgroundDAO;

public class JDBCCampgroundDAO implements CampgroundDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCCampgroundDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Campground> getCampgroundByParkId(long id) {
        List<Campground> campgrounds = new ArrayList<>();
        String sqlGetCampgroundById = "SELECT * FROM campground WHERE park_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCampgroundById, id);
        while (results.next()) {
            campgrounds.add(mapRowToCampground(results));
        }

        return campgrounds;
    }

    private Campground mapRowToCampground(SqlRowSet results) {

        Campground campground = new Campground();
        campground.setCampgroundId(results.getLong("campground_id"));
        campground.setName(results.getString("name"));
        campground.setOpenFrom(results.getLong("open_from_mm"));
        campground.setOpenTo(results.getLong("open_to_mm"));
        campground.setDailyFee(results.getBigDecimal("daily_fee"));

        return campground;
    }
}
