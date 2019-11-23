package com.techelevator.npgeek;

import java.util.List;

public interface SurveyDao {
  public void save(Survey survey);
  public List<Survey> getFavoriteParks();
  public String getParkcodeFromPark(String parkname);
}
