package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcParkDao implements ParkDao {

	private JdbcTemplate jdbcTemplate;
	public List<String> allParkNames; 
	@Autowired
	public JdbcParkDao (javax.sql.DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Park> getAllParks() {
		List<Park> allParks = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			Park park = mapRowToPark (results);	
			allParks.add(park);
		} return allParks;
	} 
	
	private Park mapRowToPark (SqlRowSet results) {
		Park newPark = new Park();
		newPark.setParkname(results.getString("parkname"));
		newPark.setParkDescription(results.getString("parkdescription"));
		newPark.setParkcode(results.getString("parkcode"));
		newPark.setAcreage(results.getInt("acreage"));
		newPark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
		newPark.setClimate(results.getString("climate"));
		newPark.setElevationInFeet(results.getInt("elevationinfeet"));
		newPark.setEntryFee(results.getInt("entryfee"));
		newPark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
		newPark.setInspirationalQuote(results.getString("inspirationalquote"));
		newPark.setMilesOfTrail(results.getDouble("milesoftrail"));
		newPark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));
		newPark.setNumberOfCampsites(results.getInt("numberofcampsites"));
		newPark.setState(results.getString("state"));
		newPark.setYearFounded(results.getInt("yearfounded"));
		return newPark;
	} 
	
	public Park getParkbyParkcode(String parkcode) {
		Park returnedPark = new Park();
		String getParkSql ="SELECT * from Park WHERE parkcode = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(getParkSql, parkcode);
		if (result.next() ) {
			returnedPark = mapRowToPark(result);
		} return returnedPark;
	}
	
	public  List<String> getAllParkNames() {
		List<String> allParkNames = new ArrayList<>();
		String sqlSelectAllParks = "SELECT parkname FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while (results.next()) {
			allParkNames.add(results.getString("parkname"));
		} return allParkNames;
	} 
	
	public void setAllParkNames(List<String> allParkNames) {
		this.allParkNames = allParkNames;
	}
}