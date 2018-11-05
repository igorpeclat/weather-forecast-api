package com.finleap.test.weather.weatherforecastapi.exception;

/**
 * The Class TransactionsEmptyException.
 */
public class HttpApiConsumeException extends WeatherForecastException {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1999283685214448367L;

	/**
	 * Instantiates a new http api consume exception.
	 */
	public HttpApiConsumeException() {
		super();
	}
	
	/**
	 * Instantiates a new http api consume exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 * @param params the params
	 */
	public HttpApiConsumeException(String message, Throwable cause, Object... params) {
		super(String.format(message, params), cause);
	}

	/**
	 * Instantiates a new http api consume exception.
	 *
	 * @param message the message
	 * @param params the params
	 */
	public HttpApiConsumeException(String message, Object... params) {
		super(String.format(message, params));
	}
	
	/**
	 * Instantiates a new http api consume exception.
	 *
	 * @param cause the cause
	 */
	public HttpApiConsumeException(Throwable cause) {
		super(cause);
	}

}
