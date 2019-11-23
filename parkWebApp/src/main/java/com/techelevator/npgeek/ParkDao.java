package com.techelevator.npgeek;

import java.util.List;

public interface ParkDao {

	public List<Park> getAllParks();
	public Park getParkbyParkcode(String parkcode);
}
