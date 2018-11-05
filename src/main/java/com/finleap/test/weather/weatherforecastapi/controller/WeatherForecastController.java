package com.finleap.test.weather.weatherforecastapi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.finleap.test.weather.weatherforecastapi.exception.WeatherForecastException;
import com.finleap.test.weather.weatherforecastapi.pojo.WeatherForecastAveragePojo;
import com.finleap.test.weather.weatherforecastapi.pojo.WeatherForecastPojo;
import com.finleap.test.weather.weatherforecastapi.service.WeatherForecastService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * The Class WeatherForecastController.
 */
@RestController
@Api(value = "weather-forecast", tags = "weather-forecast")
public class WeatherForecastController {

	/** The weather forecast service. */
	@Autowired
	private WeatherForecastService weatherForecastService;

	/**
	 * Forecast average.
	 *
	 * @param city    the city
	 * @param country the country
	 * @return the response entity
	 */
	@ApiOperation(value = "Get Averages Forecast")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "city", dataType = "string", paramType = "query", value = "City name"),
			@ApiImplicitParam(name = "country", dataType = "string", paramType = "query", value = "Country code") })
	@GetMapping("forecast-average")
	public ResponseEntity<?> forecastAverage(@RequestParam("city") String city,
			@RequestParam("country") Optional<String> country) {

		return Optional.of(city)
				// assign parameters
				.map(cityParam -> {
					String paramsJoin = cityParam;
					if (country.isPresent()) {
						List<String> valuesList = Arrays.asList(cityParam, country.get());
						paramsJoin = String.join(",", valuesList);
					}
					List<WeatherForecastPojo> weatherForecastPojos = weatherForecastService
							.getWeatherForecastByCity(paramsJoin);
					WeatherForecastAveragePojo weatherForecastAveragePojo = new WeatherForecastAveragePojo();
					weatherForecastAveragePojo
							.setAverageTemperatures(weatherForecastService.averageTemperature(weatherForecastPojos));
					weatherForecastAveragePojo
							.setAveragePressures(weatherForecastService.averagePressure(weatherForecastPojos));
					return ResponseEntity.ok(weatherForecastAveragePojo);
				}).orElseThrow(WeatherForecastException::new);

	}

}
