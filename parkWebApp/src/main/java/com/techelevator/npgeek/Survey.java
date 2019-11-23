package com.techelevator.npgeek;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



public class Survey {

	private int surveyId;
	private String parkcode;

	@Email(message = "Please enter your email address")
	private String emailAddress;

	@NotBlank(message = "Please enter a state")
	private String state;

	@NotBlank(message = "Please enter an activity level")
	private String activityLevel;

	private String parkname;

	@AssertTrue (message="Please enter valid state abbreviation (example: XX)")
	public boolean isStateValid() {
		boolean result = false;
		String expression = "AL, AK, AZ, AR, CA, CO, CT, DE, FL, GA, HI, ID, IL, IN, IA, KS, KY, LA, ME, MD, MA, MI, MN, MS, MO, MT, NE, NV, NH, NJ, NM, NY, NC, ND, OH, OK, OR, PA, RI, SC, SD, TN, TX, UT, VT, VA, WA, WV, WI, WY";
		if (expression.contains(state)) {
			result = true;
		} else {
			result = false;
		} return result;
	}
	
	@AssertTrue (message="Please enter valid park name")
	public boolean isParkValid() {
		List<String> parkList = new ArrayList<>();
			parkList.add("Cuyahoga Valley National Park");
			parkList.add("Everglades National Park");
			parkList.add("Grand Canyon National Park");
			parkList.add("Glacier National Park");
			parkList.add("Great Smoky Mountains National Park");
			parkList.add("Grand Teton National Park");
			parkList.add("Mount Rainier National Park");
			parkList.add("Rocky Mountain National Park");
			parkList.add("Yellowstone National Park");
			parkList.add("Yosemite National Park");
		
		boolean result;
		if (parkList.contains(parkname)) {
			result = true;
		} else {
			result = false;
		} return result;
	}
	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public String getParkcode() {
		return parkcode;
	}

	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getActivityLevel() {
		return activityLevel;
	}

	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}

	public String getParkname() {
		return parkname;
	}

	public void setParkname(String parkname) {
		this.parkname = parkname;
	}
	
	
}
