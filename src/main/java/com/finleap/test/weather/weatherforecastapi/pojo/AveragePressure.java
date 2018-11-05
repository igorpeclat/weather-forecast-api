package com.finleap.test.weather.weatherforecastapi.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The Class AveragePressure.
 */
public class AveragePressure {

	/** The weather date. */
	private LocalDate weatherDate;
	
	/** The average. */
	private BigDecimal average;

	/**
	 * Gets the weather date.
	 *
	 * @return the weather date
	 */
	public LocalDate getWeatherDate() {
		return weatherDate;
	}

	/**
	 * Sets the weather date.
	 *
	 * @param weatherDate the new weather date
	 */
	public void setWeatherDate(LocalDate weatherDate) {
		this.weatherDate = weatherDate;
	}

	/**
	 * Gets the average.
	 *
	 * @return the average
	 */
	public BigDecimal getAverage() {
		return average;
	}

	/**
	 * Sets the average.
	 *
	 * @param average the new average
	 */
	public void setAverage(BigDecimal average) {
		this.average = average;
	}
	
	
	
}
