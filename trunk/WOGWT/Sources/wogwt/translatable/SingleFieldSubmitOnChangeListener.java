package wogwt.translatable;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sends the value of only the changed field to the server using the form action url
 * and updates a DOM container with the response
 * 
 * Also see SubmitOnChangeListener to do an ajax submit that sends ALL form values.
 */
public class SingleFieldSubmitOnChangeListener extends SubmitOnChangeListener {

	public static final String KEY_PARTIAL_FORM_SENDER_ID = "_partialSenderID";
	
	public SingleFieldSubmitOnChangeListener() {
		super();
	}
	
	public SingleFieldSubmitOnChangeListener(String updateContainerID) {
		super(updateContainerID);
	}
	
	public SingleFieldSubmitOnChangeListener(String updateContainerID, AfterDOMUpdateCallback callback) {
		super(updateContainerID, callback);
	}
	
	/**
	 * @return the form values to be submitted.  Only the sending event's element value is sent.
	 */
	protected Map<String, String> getFormValues() {
		HashMap<String, String> formValues = new HashMap();
		
		Element senderElement = ((Widget)getSender()).getElement();
		String name = senderElement.getAttribute("name");
		String value = WOGWTClientUtil.formFieldValue(senderElement);
		
		formValues.put(name, value);
		
		formValues.put(KEY_PARTIAL_FORM_SENDER_ID, name);
		
		return formValues;
	}
	
}
