package com.finleap.test.weather.weatherforecastapi.serialize;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * The Class LocalDateTimeDeserializer.
 */
public class LocalDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

	/* (non-Javadoc)
	 * @see com.fasterxml.jackson.databind.JsonDeserializer#deserialize(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext)
	 */
	@Override
	public LocalDateTime deserialize(final JsonParser json, final DeserializationContext ctxt) throws IOException {
		if (!StringUtils.isBlank(json.getText())) {
			return LocalDateTime.parse(json.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		return null;
	}
}