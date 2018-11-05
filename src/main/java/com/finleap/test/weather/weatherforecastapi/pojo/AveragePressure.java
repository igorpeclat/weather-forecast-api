package com.finleap.test.weather.weatherforecastapi.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AveragePressure {

	
	private LocalDate weatherDate;
	
	private BigDecimal average;

	public LocalDate getWeatherDate() {
		return weatherDate;
	}

	public void setWeatherDate(LocalDate weatherDate) {
		this.weatherDate = weatherDate;
	}

	public BigDecimal getAverage() {
		return average;
	}

	public void setAverage(BigDecimal average) {
		this.average = average;
	}
	
	
	
}
