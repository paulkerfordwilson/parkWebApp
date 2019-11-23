package com.techelevator.npgeek;

public class Weather {

	private String parkcode;
	private int fiveDayForecastValue;
	private int low;
	private int high;
	private String forecast;
	private String forecastImageString;
	private String forecastMessage;
	private String forecastToString;
	private int lowCelsius;
	private int highCelsius;

	public String getParkcode() {
		return parkcode;
	}

	
	

	public void setParkcode(String parkcode) {
		this.parkcode = parkcode;
	}

	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}

	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public void setForecastImageString(String forecastImageString) {
		this.forecastImageString = forecastImageString;
	}

	public String getForecastImageString() {
		String[] words = forecast.split(" ");
		String capitalString = "";
		String start = words[0];
		for (int i = 1; i < words.length; i++) {
			String word = words[i];
			String capitalizeWord = word.substring(0, 1).toUpperCase() + word.substring(1);
			capitalString += capitalizeWord;
		}
		String result = (start + capitalString);
		return result;
	}
	
	public void setForecastMessage(String forecastMessage) {
		this.forecastMessage = forecastMessage;
	}

	public String getForecastMessage() {
	String forecastMessage = "";
	int hot = 75;
	int swing = 20;
	int cold = 20;

		if (forecast.equals("snow")) {
			forecastMessage =forecastMessage.concat("Pack Snowshoes. ");
		} else if (forecast.equals("rain")) {
			forecastMessage =forecastMessage.concat("Pack rain gear and wear waterproof shoes. ");
		} else if (forecast.equals("thunderstorms")) {
			forecastMessage =forecastMessage.concat("Seek shelter and avoid hiking on exposed ridges. ");
		} else if (forecast.equals("sunny")) {
			forecastMessage =forecastMessage.concat("Pack sunblock. ");
		} else {
			forecastMessage =forecastMessage.concat("Use common sense. ");
		}
		
		if (high > hot) {
			forecastMessage =forecastMessage.concat("Bring an extra gallon of water. ");
		}
		
		if ((high-low)>20) {
			forecastMessage =forecastMessage.concat("Wear breathable layers. ");
		}
		
		if (low < cold) {
			forecastMessage =forecastMessage.concat("Frigid temperatures can be very dangerous. Use caution. ");
		} return forecastMessage;
	}

	
	public void setForecastToString(String forecastToString) {
		this.forecastToString = forecastToString;
	}
	
	public String getForecastToString() {
		String[] words = forecast.split(" ");
		String capitalString = "";
		String start = words[0];
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String capitalizeWord = word.substring(0, 1).toUpperCase() + word.substring(1);
			capitalString += capitalizeWord + " ";
		}
		String result =  capitalString;
		return result;
	}

	public void setLowCelsius(int lowCelsius) {
		this.lowCelsius = lowCelsius;
		
	}

	public int getLowCelsius() {
		int result;
		result = (int)((low-32.0)*(5/9.0));
		lowCelsius=result;
		return lowCelsius;
	}


	public void setHighCelsius(int highCelsius) {
		this.highCelsius = highCelsius;
				
	}
	public int getHighCelsius() {
		int result;
		result = (int)((high-32.0)*(5/9.0));
		highCelsius=result;
		return highCelsius;
	}

}
