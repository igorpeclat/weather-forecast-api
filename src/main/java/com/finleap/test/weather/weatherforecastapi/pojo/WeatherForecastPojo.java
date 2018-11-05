package com.finleap.test.weather.weatherforecastapi.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.finleap.test.weather.weatherforecastapi.serialize.LocalDateTimeDeserializer;

/**
 * The Class WeatherForecastPojo.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastPojo {

	/** The main. */
	private MainPojo main;

	/** The local date time weather. */
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonProperty("dt_txt")
	private LocalDateTime localDateTimeWeather;
	
	/** The local date weather. */
	private LocalDate localDateWeather;

	/**
	 * Gets the main.
	 *
	 * @return the main
	 */
	public MainPojo getMain() {
		return main;
	}

	/**
	 * Sets the main.
	 *
	 * @param main the new main
	 */
	public void setMain(MainPojo main) {
		this.main = main;
	}

	/**
	 * Gets the local date time weather.
	 *
	 * @return the local date time weather
	 */
	public LocalDateTime getLocalDateTimeWeather() {
		return localDateTimeWeather;
	}

	/**
	 * Sets the local date time weather.
	 *
	 * @param localDateTimeWeather the new local date time weather
	 */
	public void setLocalDateTimeWeather(LocalDateTime localDateTimeWeather) {
		this.localDateTimeWeather = localDateTimeWeather;
	}

	/**
	 * Gets the local date weather.
	 *
	 * @return the local date weather
	 */
	public LocalDate getLocalDateWeather() {
		if(localDateTimeWeather!=null && localDateWeather == null) {
			localDateWeather = localDateTimeWeather.toLocalDate();
		}
		return localDateWeather;
	}

	/**
	 * Sets the local date weather.
	 *
	 * @param localDateWeather the new local date weather
	 */
	public void setLocalDateWeather(LocalDate localDateWeather) {
		this.localDateWeather = localDateWeather;
	}
	
	

}
