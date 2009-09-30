package wogwt.translatable.utils;

import java.util.Collection;
import java.util.Iterator;

public class StringUtils {

	private StringUtils() {
	}

	public static boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}

	public static boolean isNotEmpty(String value) {
		return value != null && value.length() > 0;
	}

	public static boolean isDigits(String value) {
		return value.matches("[0-9]+");
	}
	
	public static String join(Collection<?> values, String delimiter) {
		StringBuilder result = new StringBuilder();
		for (Iterator iterator = values.iterator(); iterator.hasNext();) {
			Object value = (Object) iterator.next();
			result.append(value);
			if (iterator.hasNext()) {
				result.append(delimiter);
			}
		}
		return result.toString();
	}
	
}
