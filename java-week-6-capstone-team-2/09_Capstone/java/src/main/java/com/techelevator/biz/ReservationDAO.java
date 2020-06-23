package com.techelevator.biz;

import com.techelevator.entity.Reservation;
import com.techelevator.entity.Site;

import java.time.LocalDate;
import java.util.List;

public interface ReservationDAO {

    public List<Site> getAvailableSites (long campgroundId, LocalDate fromDate, LocalDate toDate);
    public Reservation makeReservation(Reservation reservation);
}
