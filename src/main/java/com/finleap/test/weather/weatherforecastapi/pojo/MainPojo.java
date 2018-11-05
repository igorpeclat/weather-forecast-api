package com.finleap.test.weather.weatherforecastapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * The Class MainPojo.
 */
@JsonRootName("main")
public class MainPojo {

	/** The temp. */
	private Double temp;
	
	/** The temp min. */
	@JsonProperty("temp_min")
	private Double tempMin;
	
	/** The temp max. */
	@JsonProperty("temp_max")
	private Double tempMax;
	
	/** The pressure. */
	private Double pressure;
	
	/** The sea level. */
	@JsonProperty("sea_level")
	private Double seaLevel;
	
	/** The grnd level. */
	@JsonProperty("grnd_level")
	private Double grndLevel;
	
	/** The humidity. */
	private Integer humidity;
	
	/** The temp kf. */
	@JsonProperty("temp_kf")
	private Integer tempKf;

	/**
	 * Gets the temp.
	 *
	 * @return the temp
	 */
	public Double getTemp() {
		return temp;
	}

	/**
	 * Sets the temp.
	 *
	 * @param temp the new temp
	 */
	public void setTemp(Double temp) {
		this.temp = temp;
	}

	/**
	 * Gets the temp min.
	 *
	 * @return the temp min
	 */
	public Double getTempMin() {
		return tempMin;
	}

	/**
	 * Sets the temp min.
	 *
	 * @param tempMin the new temp min
	 */
	public void setTempMin(Double tempMin) {
		this.tempMin = tempMin;
	}

	/**
	 * Gets the temp max.
	 *
	 * @return the temp max
	 */
	public Double getTempMax() {
		return tempMax;
	}

	/**
	 * Sets the temp max.
	 *
	 * @param tempMax the new temp max
	 */
	public void setTempMax(Double tempMax) {
		this.tempMax = tempMax;
	}

	/**
	 * Gets the pressure.
	 *
	 * @return the pressure
	 */
	public Double getPressure() {
		return pressure;
	}

	/**
	 * Sets the pressure.
	 *
	 * @param pressure the new pressure
	 */
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}

	/**
	 * Gets the sea level.
	 *
	 * @return the sea level
	 */
	public Double getSeaLevel() {
		return seaLevel;
	}

	/**
	 * Sets the sea level.
	 *
	 * @param seaLevel the new sea level
	 */
	public void setSeaLevel(Double seaLevel) {
		this.seaLevel = seaLevel;
	}

	/**
	 * Gets the grnd level.
	 *
	 * @return the grnd level
	 */
	public Double getGrndLevel() {
		return grndLevel;
	}

	/**
	 * Sets the grnd level.
	 *
	 * @param grndLevel the new grnd level
	 */
	public void setGrndLevel(Double grndLevel) {
		this.grndLevel = grndLevel;
	}

	/**
	 * Gets the humidity.
	 *
	 * @return the humidity
	 */
	public Integer getHumidity() {
		return humidity;
	}

	/**
	 * Sets the humidity.
	 *
	 * @param humidity the new humidity
	 */
	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	/**
	 * Gets the temp kf.
	 *
	 * @return the temp kf
	 */
	public Integer getTempKf() {
		return tempKf;
	}

	/**
	 * Sets the temp kf.
	 *
	 * @param tempKf the new temp kf
	 */
	public void setTempKf(Integer tempKf) {
		this.tempKf = tempKf;
	}

}