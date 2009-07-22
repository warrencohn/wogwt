package wogwt.translatable.http;

import java.util.Map;

import wogwt.translatable.WOGWTClientUtil;

import com.google.gwt.dom.client.FormElement;
import com.google.gwt.gen2.logging.shared.Log;

/**
 * Sends the all the form values to the server using the form action url
 * and updates a DOM container with the response.
 * 
 * This class provides the basic functionality that supports it's descendants,
 *
 */
public abstract class SubmitUpdater extends Updater {

	public SubmitUpdater() {
		super();
	}
	
	public SubmitUpdater(String updateContainerID) {
		super(updateContainerID);
	}
	
	public SubmitUpdater(String updateContainerID, AfterDOMUpdateCallback callback) {
		super(updateContainerID, callback);
	}
	
//	private FormElement form;
//	
//	/**
//	 * Main entry point for this class
//	 * @param form
//	 */
//	public void fireUpdate(FormElement form) {
//		this.form = form;
//	}
//	
	@Override
	/**
	 * You shouldn't call this method, but should call fireUpdate(form) instead
	 */
	public void fireUpdate() {
		if (getForm() == null) {
			Log.severe("No form element available");
			return;
		} else if (getForm().getAction() == null) {
			Log.severe("Form " + getForm().getId() + " doesn't have an action url");
			return;
		}
		
		super.fireUpdate();
	}
	
	@Override
	protected boolean usePostRequestMethod() {
		return true;
	}
	
	@Override
	/**
	 * @return url to submit the form values to
	 */
	protected String getUrl() {
		return WOGWTClientUtil.componentUrlToAjaxUrl(getForm().getAction(), getUpdateContainerID());
	}
	
	
	@Override
	/**
	 * @return the form values to be submitted via post.
	 */
	protected Map<String, String> getFormValues() {
		return WOGWTClientUtil.formValuesForAllFields(getForm());
	}
	
//	@Override
//	protected Object getSender() {
//		return form;
//	}
	
	protected abstract FormElement getForm();
//		return form;
//	}
	
}
