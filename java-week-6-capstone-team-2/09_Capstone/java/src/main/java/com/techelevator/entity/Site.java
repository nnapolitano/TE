package com.techelevator.entity;

import java.math.BigDecimal;

public class Site {

    private long siteId;
    private long siteNumber;
    private long maxOccupancy;
    private boolean accessible;
    private long maxRvLength;
    private boolean utilities;
    private BigDecimal dailyFee;

    public Site () {}

    public Site (long siteId, long siteNumber, long maxOccupancy, boolean accessible, long maxRvLength, boolean utilities) {
        this.siteId = siteId;
        this.siteNumber = siteNumber;
        this.maxOccupancy = maxOccupancy;
        this.accessible = accessible;
        this.maxRvLength = maxRvLength;
        this.utilities = utilities;
    }

    public long getSiteId() {
        return siteId;
    }

    public void setSiteId(long siteId) {
        this.siteId = siteId;
    }

    public long getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(long siteNumber) {
        this.siteNumber = siteNumber;
    }

    public void setMaxOccupancy(long maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public void setAccessible(boolean accessible) {
        this.accessible = accessible;
    }

    public void setMaxRvLength(long maxRvLength) {
        this.maxRvLength = maxRvLength;
    }

    public void setUtilities(boolean utilities) {
        this.utilities = utilities;
    }

    public BigDecimal getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(BigDecimal dailyFee) {
        this.dailyFee = dailyFee;
    }

    public String toString() {
        String handicapAccessible = accessible ? "Yes" : "No";
        String hasUtilities = utilities ? "Yes" : "N/A";
        return String.format("%-15d %-11d %-14s %-14d %-12s ", siteNumber, maxOccupancy, handicapAccessible, maxRvLength, hasUtilities);
    }
}
