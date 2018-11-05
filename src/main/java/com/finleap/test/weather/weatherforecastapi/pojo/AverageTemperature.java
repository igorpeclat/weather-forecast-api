package com.finleap.test.weather.weatherforecastapi.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The Class AverageTemperature.
 */
public class AverageTemperature {

	/** The weather date. */
	private LocalDate weatherDate;

	/** The average daily. */
	private BigDecimal averageDaily;

	/** The average nightly. */
	private BigDecimal averageNightly;

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
	 * Gets the average daily.
	 *
	 * @return the average daily
	 */
	public BigDecimal getAverageDaily() {
		return averageDaily;
	}

	/**
	 * Sets the average daily.
	 *
	 * @param averageDaily the new average daily
	 */
	public void setAverageDaily(BigDecimal averageDaily) {
		this.averageDaily = averageDaily;
	}

	/**
	 * Gets the average nightly.
	 *
	 * @return the average nightly
	 */
	public BigDecimal getAverageNightly() {
		return averageNightly;
	}

	/**
	 * Sets the average nightly.
	 *
	 * @param averageNightly the new average nightly
	 */
	public void setAverageNightly(BigDecimal averageNightly) {
		this.averageNightly = averageNightly;
	}

}
