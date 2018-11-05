package com.finleap.test.weather.weatherforecastapi.service;

import java.util.List;

import com.finleap.test.weather.weatherforecastapi.exception.WeatherForecastException;
import com.finleap.test.weather.weatherforecastapi.pojo.AveragePressure;
import com.finleap.test.weather.weatherforecastapi.pojo.AverageTemperature;
import com.finleap.test.weather.weatherforecastapi.pojo.WeatherForecastPojo;

/**
 * The Interface IWeatherForecastService.
 */
public interface IWeatherForecastService {
	
	/**
	 * Weather forecast by city.
	 *
	 * @param cityParam the city param
	 * @return the list
	 * @throws WeatherForecastException 
	 */
	List<WeatherForecastPojo> getWeatherForecastByCity(String cityParam) throws WeatherForecastException;
	
	/**
	 * Average temperature.
	 *
	 * @param weatherForecastPojos the weather forecast pojos
	 * @return the list
	 */
	List<AverageTemperature> averageTemperature(List<WeatherForecastPojo> weatherForecastPojos);
	
	
	/**
	 * Average pressure.
	 *
	 * @param weatherForecastPojos the weather forecast pojos
	 * @return the list
	 */
	List<AveragePressure> averagePressure(List<WeatherForecastPojo> weatherForecastPojos);

	/**
	 * Gets the weather api response.
	 *
	 * @param cityParam the city param
	 * @return the weather api response
	 */
	String getWeatherApiResponse(String cityParam);
	
	


}
