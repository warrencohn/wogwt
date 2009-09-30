package wogwt.translatable.utils;

public class MathUtils {

	private MathUtils() {
	}

	public static double round(double number, int places) {
		if (places == 0)
			return Math.round(number);
		else
			return Math.round(number * (10.0 * places)) / (10.0 * places);
	}
	
}
