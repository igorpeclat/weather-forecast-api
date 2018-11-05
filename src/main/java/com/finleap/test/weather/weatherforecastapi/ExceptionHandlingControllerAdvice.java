package com.finleap.test.weather.weatherforecastapi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.finleap.test.weather.weatherforecastapi.exception.WeatherForecastException;

// TODO: Auto-generated Javadoc
/**
 * The Class ExceptionHandlingControllerAdvice.
 */
@ControllerAdvice
public class ExceptionHandlingControllerAdvice {

	/**
	 * Handle field validation exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(value = { IllegalArgumentException.class, InvalidFormatException.class })
	public ResponseEntity<?> handleFieldValidationException(final Exception ex) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
	}
	
	/**
	 * Http client error exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(value = {HttpClientErrorException.class})
	public ResponseEntity<?> HttpClientErrorException(final Exception ex) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	/**
	 * Handle weather forecast exception.
	 *
	 * @param ex the ex
	 * @return the response entity
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(value = {WeatherForecastException.class})
	public ResponseEntity<?> handleWeatherForecastException(final WeatherForecastException ex) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}