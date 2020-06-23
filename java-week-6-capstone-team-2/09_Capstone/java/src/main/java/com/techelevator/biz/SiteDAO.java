package com.techelevator.biz;

import com.techelevator.entity.Site;

import java.time.LocalDate;
import java.util.List;

public interface SiteDAO {
    public List<Site> getAvailableSitesByReservationDate(long id, LocalDate startDate, LocalDate endDate);

}