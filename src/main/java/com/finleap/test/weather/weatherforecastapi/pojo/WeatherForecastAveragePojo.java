package com.finleap.test.weather.weatherforecastapi.pojo;

import java.util.List;

public class WeatherForecastAveragePojo {

	private List<AverageTemperature> averageTemperatures;

	private List<AveragePressure> averagePressures;

	public List<AverageTemperature> getAverageTemperatures() {
		return averageTemperatures;
	}

	public void setAverageTemperatures(List<AverageTemperature> averageTemperatures) {
		this.averageTemperatures = averageTemperatures;
	}

	public List<AveragePressure> getAveragePressures() {
		return averagePressures;
	}

	public void setAveragePressures(List<AveragePressure> averagePressures) {
		this.averagePressures = averagePressures;
	}

}
