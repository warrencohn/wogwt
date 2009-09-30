package wogwt.translatable.utils;

public class DateUtils {

	public static native int timeZoneOffset() /*-{
		return new Date().getTimezoneOffset();
	}-*/;

}
