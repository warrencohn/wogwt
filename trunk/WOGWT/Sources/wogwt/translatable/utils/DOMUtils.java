package wogwt.translatable.utils;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;

public class DOMUtils {

	public static void removeElement(Element element) {
		if (element != null && element.getParentElement() != null) {
			element.getParentElement().removeChild(element);
		}
	}
	
	public static void appendBreak(Element element) {
		element.appendChild(Document.get().createBRElement());
	}
	
	public static void appendBreak(String elementID) {
		appendBreak(Document.get().getElementById(elementID));
	}
	
	public static void appendBreak(Element element, int count) {
		for (int i = 0; i < count; i++) {
			appendBreak(element);
		}
	}
	
	public static void appendBreak(String elementID, int count) {
		for (int i = 0; i < count; i++) {
			appendBreak(elementID);
		}
	}
	
	public static void appendSpace(Element element) {
		element.appendChild(Document.get().createTextNode(" "));
	}
	
	public static void appendSpace(String elementID) {
		appendSpace(Document.get().getElementById(elementID));
	}
	
	public static void appendNonbreakingSpace(Element element) {
		element.appendChild(Document.get().createTextNode("\u00a0"));
	}
	
	public static void appendNonbreakingSpace(String elementID) {
		appendNonbreakingSpace(Document.get().getElementById(elementID));
	}
	
	public static void appendNonbreakingSpace(Element element, int count) {
		for (int i = 0; i < count; i++) {
			appendNonbreakingSpace(element);
		}
	}
	
	public static void appendNonbreakingSpace(String elementID, int count) {
		for (int i = 0; i < count; i++) {
			appendNonbreakingSpace(elementID);
		}
	}
	
	public static void appendText(Element element, String text) {
		element.appendChild(Document.get().createTextNode(text));
	}
	
	public static void appendText(String elementID, String text) {
		appendText(Document.get().getElementById(elementID), text);
	}
	
}
