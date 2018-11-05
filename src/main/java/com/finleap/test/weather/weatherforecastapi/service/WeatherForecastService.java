package com.finleap.test.weather.weatherforecastapi.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finleap.test.weather.weatherforecastapi.exception.WeatherForecastException;
import com.finleap.test.weather.weatherforecastapi.pojo.AveragePressure;
import com.finleap.test.weather.weatherforecastapi.pojo.AverageTemperature;
import com.finleap.test.weather.weatherforecastapi.pojo.WeatherForecastPojo;
import com.finleap.test.weather.weatherforecastapi.utils.Utils;
import com.jayway.jsonpath.JsonPath;

/**
 * The Class WeatherForecastService.
 */
@Service
public class WeatherForecastService implements IWeatherForecastService {

	/** The weather api. */
	@Value("${openweathermap.api}")
	private String weatherApi;

	/** The api key. */
	@Value("${openweathermap.api.key}")
	private String apiKey;
	
	@Value("${openweathermap.api.forecast}")
	private String apiForecast;


	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.finleap.test.weather.weatherforecastapi.service.IWeatherForecastService#
	 * fiveDaysWeatherForecastByCity(java.lang.String)
	 */
	@Override
	public List<WeatherForecastPojo> getWeatherForecastByCity(String cityParam) throws WeatherForecastException{
		List<WeatherForecastPojo> weatherForecastPojos = null;
		try {
			String weatherForecasResponse = getWeatherApiResponse(cityParam);
			//return specific json node for manipulation
			List<String> listWeatherApi = JsonPath.parse(weatherForecasResponse).read("$.list[*]");
			weatherForecastPojos = new ObjectMapper().readValue(listWeatherApi.toString(), new TypeReference<List<WeatherForecastPojo>>() {});
		} catch (Exception e) {
			throw new WeatherForecastException(e.getMessage(), e);
		}
		return weatherForecastPojos;
	}

	/**
	 * Gets the weather api response.
	 *
	 * @param cityParam the city param
	 * @return the weather api response
	 */
	@Override
	@Cacheable("weather-forecast-api")
	public String getWeatherApiResponse(String cityParam) {
		String forecastUrl = String.format(apiForecast, weatherApi);
		return new RestTemplate().getForObject(forecastUrl, String.class, cityParam, apiKey);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.finleap.test.weather.weatherforecastapi.service.IWeatherForecastService#
	 * averageTemperature(java.util.List)
	 */
	@Override
	public List<AverageTemperature> averageTemperature(List<WeatherForecastPojo> weatherForecastPojos) {
		LocalDateTime initDateTemp = LocalDateTime.now().plusDays(1).withHour(5).withMinute(29);
		LocalDateTime finalDateTemp = LocalDateTime.now().plusDays(4).withHour(6).withMinute(1);
		//Filter the list to separate only valid slots
		List<WeatherForecastPojo> listTemp = weatherForecastPojos.stream()
				.filter(s -> initDateTemp.isBefore(s.getLocalDateTimeWeather())
						&& finalDateTemp.isAfter(s.getLocalDateTimeWeather()))
				.collect(Collectors.toList());

		//Chop the list in several parts for average daily and nightly
		List<List<WeatherForecastPojo>> weatherHoursParts = Utils.chopped(listTemp, 5);

		List<AverageTemperature> averageTemperatures = new ArrayList<>();
		
		//Day 1 average 
		AverageTemperature averageTemperatureDay1 = new AverageTemperature();
		averageTemperatureDay1.setAverageDaily(Utils.roundDeafault(new BigDecimal(
				weatherHoursParts.get(0).stream().collect(Collectors.averagingDouble(e -> e.getMain().getTemp())).doubleValue())));
		averageTemperatureDay1.setAverageNightly(Utils.roundDeafault(new BigDecimal(
				weatherHoursParts.get(1).stream().collect(Collectors.averagingDouble(e -> e.getMain().getTemp())).doubleValue())));
		averageTemperatureDay1.setWeatherDate(weatherHoursParts.get(0).get(0).getLocalDateWeather());
		averageTemperatures.add(averageTemperatureDay1);

		//Day 2 average 
		AverageTemperature averageTemperatureDay2 = new AverageTemperature();
		averageTemperatureDay2.setAverageDaily(Utils.roundDeafault(new BigDecimal(
				weatherHoursParts.get(2).stream().collect(Collectors.averagingDouble(e -> e.getMain().getTemp())).doubleValue())));
		averageTemperatureDay2.setAverageNightly(Utils.roundDeafault(new BigDecimal(
				weatherHoursParts.get(3).stream().collect(Collectors.averagingDouble(e -> e.getMain().getTemp())).doubleValue())));
		averageTemperatureDay2.setWeatherDate(weatherHoursParts.get(2).get(0).getLocalDateWeather());
		averageTemperatures.add(averageTemperatureDay2);

		//Day 3 average 
		AverageTemperature averageTemperatureDay3 = new AverageTemperature();
		averageTemperatureDay3.setAverageDaily(Utils.roundDeafault(new BigDecimal(
				weatherHoursParts.get(4).stream().collect(Collectors.averagingDouble(e -> e.getMain().getTemp())).doubleValue())));
		averageTemperatureDay3.setAverageNightly(Utils.roundDeafault(new BigDecimal(
				weatherHoursParts.get(5).stream().collect(Collectors.averagingDouble(e -> e.getMain().getTemp())).doubleValue())));
		averageTemperatureDay3.setWeatherDate(weatherHoursParts.get(4).get(0).getLocalDateWeather());
		averageTemperatures.add(averageTemperatureDay3);
		
		//sort date ascending
		return averageTemperatures.stream().sorted(Comparator.comparing(AverageTemperature::getWeatherDate))
				.collect(Collectors.toList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.finleap.test.weather.weatherforecastapi.service.IWeatherForecastService#
	 * averagePressure(java.util.List)
	 */
	@Override
	public List<AveragePressure> averagePressure(List<WeatherForecastPojo> weatherForecastPojos) {
		LocalDate datePressureInit = LocalDate.now();
		LocalDate datePressureFinal = LocalDate.now().plusDays(4);
		//Filter the list to separate only valid slots
		List<WeatherForecastPojo> listPressure = weatherForecastPojos.stream()
				.filter(s -> s.getLocalDateWeather().isAfter(datePressureInit)
						&& s.getLocalDateWeather().isBefore(datePressureFinal))
				.collect(Collectors.toList());

		//Group by date and their respective averages of pressure
		Map<LocalDate, Double> averagePressure = listPressure.stream().collect(Collectors.groupingBy(
				WeatherForecastPojo::getLocalDateWeather, Collectors.averagingDouble(i -> i.getMain().getPressure())));

		//convert to response pojo
		List<AveragePressure> averagePressures = new ArrayList<>();
		averagePressure.entrySet().stream().forEach(e -> {
			AveragePressure avgPre = new AveragePressure();
			avgPre.setAverage(Utils.roundDeafault(new BigDecimal(e.getValue())));
			avgPre.setWeatherDate(e.getKey());
			averagePressures.add(avgPre);
		});
		//sort date ascending
		return averagePressures.stream().sorted(Comparator.comparing(AveragePressure::getWeatherDate))
				.collect(Collectors.toList());
	}

}
