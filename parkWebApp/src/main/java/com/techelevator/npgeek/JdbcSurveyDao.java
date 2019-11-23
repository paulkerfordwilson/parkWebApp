package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcSurveyDao(javax.sql.DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void save(Survey survey) {
		
		String parkcode =getParkcodeFromPark(survey.getParkname());
		
		
		
		
		String sqlInsertSurvey = "INSERT INTO survey_result( parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey,  parkcode, survey.getEmailAddress(), survey.getState(),
				survey.getActivityLevel());
	}

	private Long getNextId() {
		String sqlSelectNext = "SELECT NEXTVAL('seq_survey_id')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNext);
		Long id = null;
		if (results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Unable to select next survey id from sequence");
		}
		return id;
	}

	public List<Survey> getFavoriteParks() {
		List<Survey> favoriteParks = new ArrayList<>();
		String sqlSelectAllSurveys = "SELECT * FROM survey_result";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while (results.next()) {
			Survey survey = new Survey();
			survey.setParkcode(results.getString("parkcode"));
		}
		return favoriteParks;

	}
	
	public String getParkcodeFromPark(String parkname) {
		String returnedParkcode ="";
		String getParkcodeSql ="SELECT parkcode from Park WHERE parkname = ?;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(getParkcodeSql, parkname);
		if (result.next() ) {
			returnedParkcode = result.getString("parkcode");
		} return returnedParkcode;
	}
}
