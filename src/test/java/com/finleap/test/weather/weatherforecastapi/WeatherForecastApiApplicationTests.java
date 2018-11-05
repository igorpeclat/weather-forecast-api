package com.finleap.test.weather.weatherforecastapi;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

// TODO: Auto-generated Javadoc
/**
 * The Class WeatherForecastApiApplicationTests.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WeatherForecastApiApplicationTests {

	/** The mvc. */
	@Autowired
	private MockMvc mvc;

	/** The Constant MAIN_PATH. */
	private static final String PATH_AVERAGE = "/forecast-average";
	

	/**
	 * Test A average success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testA_average_successCityAndCountry() throws Exception {
		this.mvc.perform(get(PATH_AVERAGE)
				.param("city", "Sao Paulo")
				.param("country", "br"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.averageTemperatures", iterableWithSize(3)))
				.andExpect(jsonPath("$.averagePressures", iterableWithSize(3)))
				.andExpect(jsonPath("$.averageTemperatures[0].weatherDate", is(LocalDate.now().plusDays(1).toString())))
				.andExpect(jsonPath("$.averagePressures[0].weatherDate", is(LocalDate.now().plusDays(1).toString())));
	}
	
	/**
	 * Test A average success.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testB_average_successCity() throws Exception {
		this.mvc.perform(get(PATH_AVERAGE)
				.param("city", "Sao Paulo"))
				.andExpect(status().isOk())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.averageTemperatures", iterableWithSize(3)))
				.andExpect(jsonPath("$.averagePressures", iterableWithSize(3)))
				.andExpect(jsonPath("$.averageTemperatures[0].weatherDate", is(LocalDate.now().plusDays(1).toString())))
				.andExpect(jsonPath("$.averagePressures[0].weatherDate", is(LocalDate.now().plusDays(1).toString())));;
	}
	
	/**
	 * Test C average missing param bad request.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testC_average_missingParam_badRequest() throws Exception {
		this.mvc.perform(get(PATH_AVERAGE))
				.andExpect(status().isBadRequest());
	}
	
	/**
	 * Test D average not content.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testD_average_notContent() throws Exception {
		this.mvc.perform(get(PATH_AVERAGE)
				.param("city", "!asd"))
				.andExpect(status().isNoContent());
	}
	
}
