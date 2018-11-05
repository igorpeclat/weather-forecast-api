package com.finleap.test.weather.weatherforecastapi.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AverageTemperature {

	private LocalDate weatherDate;

	private BigDecimal averageDaily;

	private BigDecimal averageNightly;

	public LocalDate getWeatherDate() {
		return weatherDate;
	}

	public void setWeatherDate(LocalDate weatherDate) {
		this.weatherDate = weatherDate;
	}

	public BigDecimal getAverageDaily() {
		return averageDaily;
	}

	public void setAverageDaily(BigDecimal averageDaily) {
		this.averageDaily = averageDaily;
	}

	public BigDecimal getAverageNightly() {
		return averageNightly;
	}

	public void setAverageNightly(BigDecimal averageNightly) {
		this.averageNightly = averageNightly;
	}

}
