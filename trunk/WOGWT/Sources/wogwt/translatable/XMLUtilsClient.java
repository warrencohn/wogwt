package wogwt.translatable;

import com.google.gwt.user.client.DOM;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.NamedNodeMap;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.NodeList;
import com.google.gwt.xml.client.XMLParser;

/**
 * These utilities can be used to extract an UpdateContainer from an
 * XHTML ajax response if you want to do that on the client instead of
 * server.  So you could send the whole response and take out the parts
 * you're interested in.
 *
 */
public class XMLUtilsClient {

	public XMLUtilsClient() {
		super();
	}
	
	/**
	 * Parses the xhtml and returns the element with the matching id or null
	 * @param xhtml
	 * @param id
	 * @return the element with the matching id or null
	 */
	public static Element xmlElementWithID(String xhtml, String id) {
		Document doc = XMLParser.parse(xhtml);
		Element node = doc.getElementById(id);
		if (node == null) {
			return null;
		}
		return node;
	}
	
	/**
	 * Parses the xhtml and returns the body element
	 * @param xhtml
	 * @return the body element
	 */
	public static Node extractBody(String xhtml) {
		Document doc = XMLParser.parse(xhtml);
		NodeList nodes = doc.getElementsByTagName("body");
		if (nodes.getLength() == 0) {
			return null;
		}
		
		Node body = nodes.item(0);
		
		return body;
	}
	
	/**
	 * @param node
	 * @return the HTML string for the node and it's children (deep)
	 */
	public static String nodeToString(Node node) {
		StringBuffer result = new StringBuffer();

		if (node.getNodeType() == Node.TEXT_NODE) {
			result.append(node.getNodeValue());
			return result.toString();
		}
		
		result.append("<");
		result.append(node.getNodeName());
		
		if (node.hasAttributes())
			result.append(" ");
		
		NamedNodeMap attributes = node.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Node attribute = attributes.item(i);
			result.append(attribute.getNodeName());
			result.append("=\"");
			result.append(attribute.getNodeValue());
			result.append("\" ");
		}
		
		if (node.hasChildNodes() || dontSelfCloseTag(node)) {
			result.append(">");
			
			NodeList children = node.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node child = children.item(i);
				result.append(nodeToString(child));
			}
			
			result.append("</");
			result.append(node.getNodeName());
			result.append(">");
		} else {
			result.append("/>");
		}
		
		return result.toString();
	}
	
	/**
	 * 
	 * @param node
	 * @return the HTML string for the node's children (deep)
	 */
	public static String childrenToString(Node node) {
		if (node.getNodeType() == Node.TEXT_NODE) {
			return "";
		}
		
		StringBuffer result = new StringBuffer();
		
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			result.append(nodeToString(child));
		}	
		
		return result.toString();
	}
	
	private static final String[] nonSelfClosingTags = {
		"iframe",
		"link",
		"style"
	};
	
	public static boolean dontSelfCloseTag(Node node) {
		for (int i = 0; i < nonSelfClosingTags.length; i++) {
			if (node.getNodeName().equals(nonSelfClosingTags[i]))
				return true;
		}
		return false;
	}
	
	/**
	 * Extracts the element with id from the xhtml passed in and replaces
	 * the DOM element with id with the children of the extracted node
	 * @param xhtml
	 * @param id
	 */
	public static void replaceContents(String xhtml, String id ) {
		replaceContents(xhtml, id, id);
	}
	
	/**
	 * Extracts the element with id from the xhtml passed in and replaces
	 * the DOM element with id with the children of the extracted node
	 * @param xhtml
	 * @param xhtmlID id for the element to extract from the xhtml
	 * @param domID id in the DOM whose contents you want to replace
	 */
	public static void replaceContents(String xhtml, String xhtmlID, String domID ) {
		com.google.gwt.xml.client.Element node = XMLUtilsClient.xmlElementWithID(xhtml, xhtmlID);
		String childrenAsString = XMLUtilsClient.childrenToString(node);
		DOM.getElementById(domID).setInnerHTML(childrenAsString);
	}
}
