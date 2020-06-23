package com.techelevator.entity;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class Campground {

    private long campgroundId;
    private String name;
    private long openFrom;
    private long openTo;
    private BigDecimal dailyFee;

    public Campground() {}

    public long getCampgroundId() {
        return campgroundId;
    }

    public void setCampgroundId(long campgroundId) {
        this.campgroundId = campgroundId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOpenFrom() {
        return openFrom;
    }

    public void setOpenFrom(long open_from) {
        this.openFrom = open_from;
    }

    public long getOpenTo() {
        return openTo;
    }

    public void setOpenTo(long open_to) {
        this.openTo = open_to;
    }

    public BigDecimal getDailyFee() {
        return dailyFee;
    }

    public void setDailyFee(BigDecimal dailyFee) {
        this.dailyFee = dailyFee;
    }

    public String toString() {
        return String.format("%-32s%-10s%-12s%s", getName(), MonthList.getMonthFromList(String.valueOf(getOpenFrom())),
                MonthList.getMonthFromList(String.valueOf(getOpenTo())),
                NumberFormat.getCurrencyInstance().format(getDailyFee()));
    }
}
