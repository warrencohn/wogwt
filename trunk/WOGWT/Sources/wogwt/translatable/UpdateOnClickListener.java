package wogwt.translatable;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;

/** 
 * Intended mainly to turn a regular WOHyperlink with an ACTION binding into an
 * ajax link.
 * 
 * This listener will do an ajax request to the url obtained from the onClick sender's
 * "href" attribute and replace the updateContainer
 * with the response.
 *
 */
public class UpdateOnClickListener extends Updater implements ClickListener {

	private Widget eventSender;
	
	public UpdateOnClickListener() {
		super();
	}
	
	public UpdateOnClickListener(String updateContainerID) {
		super(updateContainerID);
	}
	
	public UpdateOnClickListener(String updateContainerID, AfterDOMUpdateCallback callback) {
		super(updateContainerID, callback);
	}
	
	public UpdateOnClickListener(String actionName, String updateContainerID, AfterDOMUpdateCallback callback) {
		super(actionName, updateContainerID, callback);
	}
	
	public void onClick(Widget sender) {
		Log.debug("onClick: " + sender.getElement().getId());
		
		eventSender = sender;
		try {
			fireUpdate();
		} finally {
			eventSender = null;
			if (Event.getCurrentEvent() != null)
				Event.getCurrentEvent().preventDefault();
		}
	}
	
	@Override
	/**
	 * @return the widget that sent the onClick even
	 */
	protected Object getSender() {
		return eventSender;
	}
	
	@Override
	/**
	 * @return the "href" attribute of the widget that sent the onClick event,
	 * which is orginally a component action url (/wo/) and is transformed to
	 * an ajax url (/ja/) by the method.  The action url should return null.
	 */
	protected String getUrl() {
		if (getActionName() == null) {
			String url = ((Widget)getSender()).getElement().getAttribute("href");
			return WOGWTClientUtil.componentUrlToAjaxUrl(url, getUpdateContainerID());
		} else {
			return super.getUrl();
		}
	}
}
