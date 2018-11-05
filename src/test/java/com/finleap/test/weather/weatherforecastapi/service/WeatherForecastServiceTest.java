package com.finleap.test.weather.weatherforecastapi.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Answers;
import org.mockito.Mock;

import com.finleap.test.weather.weatherforecastapi.pojo.WeatherForecastPojo;
import com.finleap.test.weather.weatherforecastapi.utils.Utils;

/**
 * The Class TransactionRepositoryTest.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WeatherForecastServiceTest {

	/** The transaction repository. */
	private WeatherForecastService weatherForecastService;

	/** The Constant CITY_PARAM. */
	private static final String CITY_PARAM = "London";

	/** The Constant LONDON_JSON_SAMPLE. */
	private static final String LONDON_JSON_SAMPLE = "london-forecast-sample.json";

	/**
	 * Sets the up.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Before
	public void setUp() throws IOException {
		weatherForecastService = mock(WeatherForecastService.class, Answers.RETURNS_DEEP_STUBS);
		String json = Utils.getFileFromClassLoader(LONDON_JSON_SAMPLE);
		when(weatherForecastService.getWeatherApiResponse(CITY_PARAM)).thenReturn(json);
//		when(weatherForecastService.getWeatherForecastByCity(any(String.class))).thenReturn(new ArrayList<WeatherForecastPojo>());
	}

	/**
	 * Test A get weather reponse not empty or null.
	 */
	@Test
	public void testA_getWeatherReponse_notEmptyOrNull() {
		assertThat(weatherForecastService.getWeatherApiResponse(CITY_PARAM), is(not(isEmptyOrNullString())));
	}

	/**
	 * Test A get weather reponse not empty or null.
	 */
	@Test
	public void testB_getWeatherReponse_notEmptyOrNull() {
		assertThat(weatherForecastService.getWeatherForecastByCity(CITY_PARAM), both(not(empty())).and(notNullValue()));
	}

	/**
	 * Test C average temperature not empty or null.
	 */
	@Test
	public void testC_averageTemperature_notEmptyOrNull() {
		assertThat(weatherForecastService.averageTemperature(new ArrayList<WeatherForecastPojo>()),
				both(not(empty())).and(notNullValue()));
	}
	
	/**
	 * Test C average pressure not empty or null.
	 */
	@Test
	public void testC_averagePressure_notEmptyOrNull() {
		assertThat(weatherForecastService.averagePressure(new ArrayList<WeatherForecastPojo>()),
				both(not(empty())).and(notNullValue()));
	}

}
