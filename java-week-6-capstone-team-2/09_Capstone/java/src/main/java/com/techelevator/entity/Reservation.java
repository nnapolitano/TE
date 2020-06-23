package com.techelevator.entity;

import java.time.LocalDate;

public class Reservation {

    private long reservationId;
    private long siteId;
    private String name;
    private LocalDate fromDate;
    private LocalDate toDate;
    private LocalDate dateCreated;

    public Reservation () {}

    public Reservation (long reservationId, long siteId, String name, LocalDate fromDate, LocalDate toDate, LocalDate dateCreated) {
        this.reservationId = reservationId;
        this.siteId = siteId;
        this.name = name;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.dateCreated = dateCreated;
    }

    public long getReservationId() {
        return reservationId;
    }

    public void setReservationId(long reservationId) {
        this.reservationId = reservationId;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String toString() {
        return "The reservation hads been made and the confirmation id is: " + reservationId;
    }
}
