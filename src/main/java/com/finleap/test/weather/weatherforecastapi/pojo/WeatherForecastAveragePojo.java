package com.finleap.test.weather.weatherforecastapi.pojo;

import java.util.List;

/**
 * The Class WeatherForecastAveragePojo.
 */
public class WeatherForecastAveragePojo {

	/** The average temperatures. */
	private List<AverageTemperature> averageTemperatures;

	/** The average pressures. */
	private List<AveragePressure> averagePressures;

	/**
	 * Gets the average temperatures.
	 *
	 * @return the average temperatures
	 */
	public List<AverageTemperature> getAverageTemperatures() {
		return averageTemperatures;
	}

	/**
	 * Sets the average temperatures.
	 *
	 * @param averageTemperatures the new average temperatures
	 */
	public void setAverageTemperatures(List<AverageTemperature> averageTemperatures) {
		this.averageTemperatures = averageTemperatures;
	}

	/**
	 * Gets the average pressures.
	 *
	 * @return the average pressures
	 */
	public List<AveragePressure> getAveragePressures() {
		return averagePressures;
	}

	/**
	 * Sets the average pressures.
	 *
	 * @param averagePressures the new average pressures
	 */
	public void setAveragePressures(List<AveragePressure> averagePressures) {
		this.averagePressures = averagePressures;
	}

}
