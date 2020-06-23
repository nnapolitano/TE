package com.techelevator.biz.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import com.techelevator.entity.Site;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.biz.ReservationDAO;
import com.techelevator.entity.Reservation;

public class JDBCReservationDAO implements ReservationDAO {

    private JdbcTemplate jdbcTemplate;

    public JDBCReservationDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Site> getAvailableSites(long campgroundId, LocalDate fromDate, LocalDate toDate) {
        List<Site> availableSites = new ArrayList<>();
        String sqlGetAvailableSites = "SELECT site_number, max_occupancy, accessible, max_rv_length,utilities,"
                + " daily_fee, site_id FROM site JOIN campground ON site.campground_id = campground.campground_id"
                +" WHERE site.campground_id = ? AND site_id NOT IN (SELECT site_id FROM reservation WHERE (?, ?)"
                + " OVERLAPS (from_date, to_date) GROUP BY site_id) LIMIT 5";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAvailableSites, campgroundId, fromDate, toDate.plusDays(1));
        while (results.next()) {
            availableSites.add(mapRowToSite(results));
        }
        return availableSites;
    }

    @Override
    public Reservation makeReservation(Reservation reservation) {
        String sqlAddReservation = "INSERT INTO reservation (site_id, name, from_date, to_date, create_date) "
                + "VALUES (?,?,?,?,?)";

        reservation.setReservationId(getNextReservationId());
        jdbcTemplate.update(sqlAddReservation, reservation.getSiteId(), reservation.getName(), reservation.getFromDate(),
                            reservation.getToDate(), reservation.getDateCreated());

        return reservation;
    }

    public long getNextReservationId() {
        SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('reservation_reservation_id_seq')");
        if(nextIdResult.next()) {
            return nextIdResult.getLong(1);
        } else {
            throw new RuntimeException("Error retrieving the next reservation id");
        }
    }

    private com.techelevator.entity.Site mapRowToSite(SqlRowSet results) {

        com.techelevator.entity.Site site = new com.techelevator.entity.Site();
        site.setSiteId(results.getLong("site_id"));
        site.setSiteNumber(results.getLong("site_number"));
        site.setMaxOccupancy(results.getLong("max_occupancy"));
        site.setAccessible(results.getBoolean("accessible"));
        site.setMaxRvLength(results.getLong("max_rv_length"));
        site.setUtilities(results.getBoolean("utilities"));
        site.setDailyFee(results.getBigDecimal("daily_fee"));

        return site;
    }
}
