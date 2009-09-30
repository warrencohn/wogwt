package wogwt.translatable.utils;

import java.util.Map;

import wogwt.translatable.AbstractEntryPoint;

import com.google.gwt.user.client.History;

public abstract class ParameterizedHistoryEntryPoint extends AbstractEntryPoint {

	private final UrlParametersFormat formatter = new UrlParametersFormat();
	
	public ParameterizedHistoryEntryPoint() {
		super();
	}

	public Map<String, String> historyParameters() {
		return (Map<String, String>) formatter.parseObject(History.getToken());
	}
	
	public void newHistoryItem(Map<String, String> historyParameters) {
		String token = formatter.format(historyParameters);
		History.newItem(token);
	}
	
}
