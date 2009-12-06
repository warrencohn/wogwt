package wogwt.translatable.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.http.client.URL;

/**
 * A formatter for url query parameters like:
 * "key1=value1&key2=value2"
 * Can be used with the history token (#) or with query parameters (?)
 * 
 * See ParameterizedHistoryEntryPoint.
 */
public class UrlParametersFormat {

	public UrlParametersFormat() {
	}

	public String escapeChars(String string) {
		return string.replace("&", "%26").replace("=", "%3D");
	}

	public String unescapeChars(String string) {
		return string.replace("%26", "&").replace("%3D", "=");
	}
	
	/**
	 * Format a Map<String, String> into a history token with the form "key1=value1&key2=value2"
	 */
	public String format(Object obj) {
		Map<String, String> map = (Map<String, String>)obj;
		
		StringBuffer result = new StringBuffer();
		for (String key : map.keySet()) {
			if (map.get(key) != null) {
				if (result.length() > 0) {
					result.append("&");
				}
				result.append(escapeChars(key));
				result.append("=");
				result.append(escapeChars(map.get(key)));
			}
		}
		
		return result.toString();
	}

	/**
	 * Parses a string with the form "key1=value1&key2=value2" into a Map<String, String>
	 */
	public Object parseObject(String source) {
		String[] parameters = source.split("&");
		Map<String, String> result = new HashMap<String, String>();
		for (int i = 0; i < parameters.length; i++) {
			String[] keyAndValue = parameters[i].split("=");
			if (keyAndValue.length >= 2) {
				result.put(unescapeChars(keyAndValue[0]), unescapeChars(keyAndValue[1]));
			}
		}
		return result;
	}

}
