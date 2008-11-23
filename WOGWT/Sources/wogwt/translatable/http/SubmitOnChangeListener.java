package wogwt.translatable.http;

import wogwt.translatable.WOGWTClientUtil;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.dom.client.FormElement;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.KeyboardListener;
import com.google.gwt.user.client.ui.Widget;

/**
 * Sends the all the form values to the server using the form action url
 * and updates a DOM container with the response
 * 
 * Also see SingleFieldSubmitOnChangeListener to do an ajax submit that sends only a single form value.
 */
public class SubmitOnChangeListener extends SubmitUpdater implements ChangeListener, KeyboardListener {

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
	
	public void onChange(Widget sender) {
		Log.debug("onChange: " + sender.getElement().getId());
		handleEvent(sender);
	}
	
	public void onKeyDown(Widget sender, char keyCode, int modifiers) {
	}
	
	public void onKeyPress(Widget sender, char keyCode, int modifiers) {
	}
	
	public void onKeyUp(Widget sender, char keyCode, int modifiers) {
		Log.debug("onKeyUp: " + sender.getElement().getId());
		handleEvent(sender);
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
