package com.finleap.test.weather.weatherforecastapi.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.finleap.test.weather.weatherforecastapi.serialize.LocalDateTimeDeserializer;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherForecastPojo {

	private MainPojo main;

	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	@JsonProperty("dt_txt")
	private LocalDateTime localDateTimeWeather;
	
	private LocalDate localDateWeather;

	public MainPojo getMain() {
		return main;
	}

	public void setMain(MainPojo main) {
		this.main = main;
	}

	public LocalDateTime getLocalDateTimeWeather() {
		return localDateTimeWeather;
	}

	public void setLocalDateTimeWeather(LocalDateTime localDateTimeWeather) {
		this.localDateTimeWeather = localDateTimeWeather;
	}

	public LocalDate getLocalDateWeather() {
		if(localDateTimeWeather!=null && localDateWeather == null) {
			localDateWeather = localDateTimeWeather.toLocalDate();
		}
		return localDateWeather;
	}

	public void setLocalDateWeather(LocalDate localDateWeather) {
		this.localDateWeather = localDateWeather;
	}
	
	

}
