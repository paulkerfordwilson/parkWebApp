package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherDao implements WeatherDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcWeatherDao(javax.sql.DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Weather> getParkWeather(Park park) {
		List<Weather> parkWeather = new ArrayList<>();
		String sqlSelectParkWeather = "select fivedayforecastvalue, low, high, parkcode, forecast from weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectParkWeather, park.getParkcode());
		while (results.next()) {
			Weather weather = mapRowToWeather(results);
			parkWeather.add(weather);
		} return parkWeather;
	}

	private Weather mapRowToWeather (SqlRowSet results) {
		Weather newWeather = new Weather();
		newWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		newWeather.setForecast(results.getString("forecast"));
		newWeather.setLow(results.getInt("low"));
		newWeather.setHigh(results.getInt("high"));
		newWeather.setParkcode(results.getString("parkcode"));

		return newWeather;
	}

	
	
	
	

}
