package com.techelevator.biz.jdbc;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.biz.SiteDAO;
import com.techelevator.entity.Site;

public class JDBCSiteDAO implements SiteDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCSiteDAO (DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getAvailableSitesByReservationDate(long id, LocalDate startDate, LocalDate endDate) {
        List<Site> availableSites = new ArrayList<>();
        String sqlGetAvailableSites =
                "SELECT site.campground_id, site_id, site_number, max_occupancy, accessible, max_rv_length, utilities," +
                        " campground.daily_fee FROM site" +
                        " JOIN campground ON" +
                        " campground.campground_id = site.campground_id" +
                        " WHERE site.campground_id  = ?" +
                        " AND site.site_id NOT IN" +
                        " (SELECT s.site_id" +
                        " FROM site s" +
                        " JOIN reservation r ON" +
                        " s.site_id = r.site_id" +
                        " WHERE s.campground_id = ?" +
                        " AND (? > r.from_date AND ? < r.to_date" +
                        " OR ? > r.from_date AND ? < r.to_date)" +
                        " OR r.from_date BETWEEN ? AND ?" +
                        " AND r.to_date BETWEEN ? AND ?));";
        Site site;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAvailableSites, id, id, startDate, startDate,
                endDate, endDate, startDate, endDate, startDate, endDate);
        while (results.next()) {
            site = mapRowToSite(results);
            availableSites.add(site);
        }
        return availableSites;
    }

    private Site mapRowToSite(SqlRowSet results) {

        Site site = new Site();
        site.setSiteId(results.getLong("site_id"));
        site.setSiteNumber(results.getLong("site_number"));
        site.setMaxOccupancy(results.getLong("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getLong("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));

        return site;
    }
}
