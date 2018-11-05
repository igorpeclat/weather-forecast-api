package com.finleap.test.weather.weatherforecastapi.utils;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * The Class Utils.
 */
public abstract class Utils {

	/**
	 * Round deafault.
	 *
	 * @param d the d
	 * @return the big decimal
	 */
	public static BigDecimal roundDeafault(BigDecimal d) {
		return round(d, 2, true);
	}

	/**
	 * Round.
	 *
	 * @param d       the d
	 * @param scale   the scale
	 * @param roundUp the round up
	 * @return the big decimal
	 */
	public static BigDecimal round(BigDecimal d, int scale, boolean roundUp) {
		int mode = (roundUp) ? BigDecimal.ROUND_UP : BigDecimal.ROUND_DOWN;
		return d.setScale(scale, mode);
	}

	/**
	 * Chopped.
	 *
	 * @param      <T> the generic type
	 * @param list the list
	 * @param L    the l
	 * @return the list
	 */
	public static <T> List<List<T>> chopped(List<T> list, final int L) {
		List<List<T>> parts = new ArrayList<List<T>>();
		final int N = list.size();
		int j = 0;
		int i;
		for (i = 0; i <= N; i += L) {
			if (i == 0 || i == N)
				parts.add(new ArrayList<T>(list.subList(i - j, Math.min(N, i + L))));
			else
				parts.add(new ArrayList<T>(list.subList(i - j, Math.min(N, i + L) - j)));
			j++;
		}
		return parts;
	}

	/**
	 * Gets the file from class loader.
	 *
	 * @param fileName the file name
	 * @return the file from class loader
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String getFileFromClassLoader(String fileName) throws IOException {
		ClassLoader classLoader = Utils.class.getClassLoader();
		InputStream in = classLoader.getResourceAsStream(fileName);
		return IOUtils.toString(in, StandardCharsets.UTF_8.name());
	}
	
}
