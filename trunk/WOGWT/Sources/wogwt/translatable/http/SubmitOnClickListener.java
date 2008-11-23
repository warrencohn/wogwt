package wogwt.translatable.http;

import java.util.Map;

import wogwt.translatable.WOGWTClientUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sends the all the form values to the server using the form action url
 * and updates a DOM container with the response.
 * 
 * This is intended to be attached to a WOSubmitButton element.
 */
public class SubmitOnClickListener extends SubmitUpdater implements ClickListener {

	/** the name (which is the element ID) of the clicked button (necessary for 
	 *  forms with multiple submit buttons) */
	public static final String AjaxFormSubmitKey = "AJAX_SUBMIT_BUTTON_NAME";

	private Widget eventSender;
	
	public SubmitOnClickListener() {
		super();
	}
	
	public SubmitOnClickListener(String updateContainerID) {
		super(updateContainerID);
	}
	
	public SubmitOnClickListener(String updateContainerID, AfterDOMUpdateCallback callback) {
		super(updateContainerID, callback);
	}
	
	public void onClick(Widget sender) {
		Log.debug("onClick: " + sender.getElement().getId());

		eventSender = sender;
		try {
			if (getForm() == null) {
				Log.error("Element " + sender.getElement().getId() + " is not contained in a form");
				return;
			} 
			
			fireUpdate();
		} finally {
			eventSender = null;
			if (Event.getCurrentEvent() != null)
				Event.getCurrentEvent().preventDefault();
		}
		
	}
	
//	@Override
//	/** method not supported */
//	public void fireUpdate(FormElement form) {
//		throw new RuntimeException("method not supported");
//	}
	
	@Override
	protected Map<String, String> getFormValues() {
		Map result = super.getFormValues();
		Element button = ((Widget)getSender()).getElement();
		result.put(button.getAttribute("name"), button.getAttribute("value"));
		//result.put(AjaxFormSubmitKey, button.getAttribute("name"));
		return result;
	}
	
	@Override
	/**
	 * @return the Widget that sent the onChangeEvent
	 */
	protected Object getSender() {
		return eventSender;
	}
	
	@Override
	protected FormElement getForm() {
		return WOGWTClientUtil.formContainingElement(eventSender.getElement());
	}
}
