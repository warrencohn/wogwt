package wogwt.server.rpc;

import java.util.List;

import wogwt.translatable.rpc.WOGWTClientEO;

public interface WOGWTServerEO {

	public WOGWTClientEO toClientEO();
	public WOGWTClientEO toClientEO(List<String> relationshipToSerialize);
	
}
