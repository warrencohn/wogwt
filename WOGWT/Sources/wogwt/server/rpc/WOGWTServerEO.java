package wogwt.server.rpc;

import java.util.List;

import wogwt.translatable.rpc.WOGWTClientEO;

/**
 * This is used to convert regular EOs to the Data-Transfer Objects
 * (WOGWTClientEO) necessary for GWT RPC calls.  Any EOs you want to
 * transfer via RPC should implement this interface.
 *
 */
public interface WOGWTServerEO {

	/**
	 * Converts this EO to a Client DTO, including all it's attribute
	 * values, but no relationships.
	 * @return the client eo
	 */
	public WOGWTClientEO toClientEO();
	
	/**
	 * Converts this EO to a Client DTO, including all it's attribute
	 * values, and the relationships given by relationshipsToSerialize.
	 * @param relationshipToSerialize
	 * @return the client eo
	 */
	public WOGWTClientEO toClientEO(List<String> relationshipsToSerialize);
	
}
