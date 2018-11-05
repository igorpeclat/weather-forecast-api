package com.finleap.test.weather.weatherforecastapi.exception;

  /**
 * The Class WeatherForecastException.
 */
public class WeatherForecastException extends RuntimeException {
	

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6734548205851575874L;

	/**
	 * Instantiates a new weather forecast exception.
	 */
	public WeatherForecastException() {
		super();
	}
	
	/**
	 * Instantiates a new weather forecast exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param params the params
	 */
	public WeatherForecastException(String message, Throwable cause, Object... params) {
		super(String.format(message, params), cause);
	}

	/**
	 * Instantiates a new weather forecast exception.
	 *
	 * @param message the message
	 * @param params the params
	 */
	public WeatherForecastException(String message, Object... params) {
		super(String.format(message, params));
	}
	
	/**
	 * Instantiates a new weather forecast exception.
	 *
	 * @param cause the cause
	 */
	public WeatherForecastException(Throwable cause) {
		super(cause);
	}

}