package wogwt.translatable.http;

import wogwt.translatable.WOGWTClientUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sends the all the form values to the server using the form action url
 * and updates a DOM container with the response
 * 
 * Also see SingleFieldSubmitOnChangeListener to do an ajax submit that sends only a single form value.
 */
public class SubmitOnChangeListener extends SubmitUpdater implements ChangeHandler, KeyUpHandler {

	private Widget eventSender;
	
	public SubmitOnChangeListener() {
		super();
	}
	
	public SubmitOnChangeListener(String updateContainerID) {
		super(updateContainerID);
	}
	
	public SubmitOnChangeListener(String updateContainerID, AfterDOMUpdateCallback callback) {
		super(updateContainerID, callback);
	}
	
	public void onChange(ChangeEvent event) {
		Log.debug("onChange: " + Element.as(event.getNativeEvent().getEventTarget()).getId());
		handleEvent((Widget)event.getSource());		
	}

	public void onKeyUp(KeyUpEvent event) {
		Log.debug("onKeyUp: " + Element.as(event.getNativeEvent().getEventTarget()).getId());
		handleEvent((Widget)event.getSource());	
	}
	
	private void handleEvent(Widget sender) {
		eventSender = sender;
		try {
			if (getForm() == null) {
				Log.error("Element " + sender.getElement().getId() + " is not contained in a form");
				return;
			} 
			
			fireUpdate();
		} finally {
			eventSender = null;
		}
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