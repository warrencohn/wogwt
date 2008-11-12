package wogwt;

import java.util.List;

import wogwt.translatable.WOGWTClientEO;

public interface WOGWTServerEO {

	public WOGWTClientEO toClientEO();
	public WOGWTClientEO toClientEO(List<String> relationshipToSerialize);
	
}
