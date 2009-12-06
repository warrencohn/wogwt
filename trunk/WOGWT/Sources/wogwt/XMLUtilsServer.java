package wogwt;

import java.io.ByteArrayInputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;

/**
 * Utility class used mainly to extract an elment and its children from
 * an XHTML page
 *
 */
public class XMLUtilsServer {

	private XMLUtilsServer() {
	}
	
	/**
	 * 
	 * @param node
	 * @return the XML string for the node and it's children (deep)
	 */
	public static String serializeNode(Node node) {
		StringWriter result = new StringWriter();
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		try {
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.transform(new DOMSource(node), new StreamResult(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	/**
	 * 
	 * @param node
	 * @return the XML string for the node's children (deep)
	 */
	public static String serializeChildren(Node node) {
		StringBuffer result = new StringBuffer();
		
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			result.append(serializeNode(child));
		}
		
		return result.toString();
	}
	
	/**
	 * Tidy doesn't implement the Document.elementById function, so this will do it
	 * by walking the tree looking for the node with the matching id.
	 */
	private static Node tidyElementByID(Node node, String id) {
		if (node.getNodeType() != Node.ELEMENT_NODE && 
				node.getNodeType() != Node.DOCUMENT_NODE)
			return null;
		
		if (node.getAttributes().getNamedItem("id") != null &&
				node.getAttributes().getNamedItem("id").getNodeValue().equals(id)) {
			return node;
		}
		
		NodeList children = node.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node result = tidyElementByID(children.item(i), id);
			if (result != null)
				return result;
		}
		
		return null;
	}
	
	/**
	 * Parses the xhtml (using Tidy) and returns the node with the matching id
	 * @param xhtml
	 * @param id 
	 * @return the node with the matching id
	 */
	public static Node xhtmlElementWithID(String xhtml, String id) {
		Node container = null;
		try {
			Tidy tidy = new Tidy();
			tidy.setXHTML(true);
			tidy.setQuiet(true);
			tidy.setErrout(new PrintWriter(new StringWriter())); // throw away output

			Document document = tidy.parseDOM(new ByteArrayInputStream(xhtml.getBytes("UTF-8")), null);
			container = tidyElementByID(document, id);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return container;
		
		// This works, but it really slow, apparently because it is fetching the DTD
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		factory.setValidating(false);
//		factory.setNamespaceAware(false);
//		factory.setIgnoringElementContentWhitespace(false);
//		Element container = null;
//		try {
//			DocumentBuilder builder = factory.newDocumentBuilder();
//			Document document = builder.parse(new InputSource(new StringReader(xhtml)));
//			container = document.getElementById(id);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return container;
	}
	
}
