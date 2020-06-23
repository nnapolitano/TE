package com.techelevator.biz;

import com.techelevator.entity.Park;

import java.util.List;

public interface ParkDAO {

    public List<Park> getAllParks();
    public List<Park> getParkById(long id);
}
