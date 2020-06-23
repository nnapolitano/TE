package com.techelevator.biz;

import com.techelevator.entity.Campground;

import java.util.List;

public interface CampgroundDAO {

    public List<Campground> getCampgroundByParkId(long id);

}