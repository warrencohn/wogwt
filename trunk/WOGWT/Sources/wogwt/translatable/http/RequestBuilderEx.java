package wogwt.translatable.http;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.http.client.RequestBuilder;

/**
 * Adds support for the PUT and DELETE http methods for REST use.
 *
 */
public class RequestBuilderEx extends RequestBuilder {

	public static final class Method {
		private final String name;

		private Method(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}
	  
	/**
	 * Specifies that the HTTP GET method should be used.
	 */
	public static final Method GET = new Method("GET");

	/**
	 * Specifies that the HTTP POST method should be used.
	 */
	public static final Method POST = new Method("POST");

	/**
	 * Specifies that the HTTP DELETE method should be used.
	 */
	public static final Method DELETE = new Method("DELETE");

	/**
	 * Specifies that the HTTP PUT method should be used.
	 */
	public static final Method PUT = new Method("PUT");
	  
	
	public RequestBuilderEx(Method httpMethod, String url) {
		this(httpMethod.name, url);
	}

	protected RequestBuilderEx(String httpMethod, String url) {
		super(httpMethod, url);
	}

	/**
	 * WARNING - UNSAFE: uses eval to parse the json
	 * @param json
	 * @return
	 */
	public native JsArray parseArray(String json) /*-{
		return eval(json);
	}-*/;
	
}
