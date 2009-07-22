package wogwt.components;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOElement;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSDictionary;

import er.ajax.AjaxUpdateContainer;

/**
 * This class can used to explicitly indicate areas you want update with ajax calls.
 * By using this then you can remove the call to:
 * 		WOGWTServerUtil.onlyIncludeUpdateContainerInResponse(request, response);
 * in Application.dispatchRequest and improve performance.
 * 
 * @author john
 *
 */
public class WOGWTUpdateContainer extends AjaxUpdateContainer {

	public WOGWTUpdateContainer(String name, NSDictionary associations, WOElement children) {
		super(name, associations, children);
	}
	
	@Override
	protected void addRequiredWebResources(WOResponse response,
			WOContext context) {
		// Don't add any scripts
		//super.addRequiredWebResources(response, context);
	}
	
	public void appendToResponse(WOResponse response, WOContext context) {
		String previousUpdateContainerID = AjaxUpdateContainer.currentUpdateContainerID();
		try {
			AjaxUpdateContainer.setCurrentUpdateContainerID(_containerID(context));
			WOComponent component = context.component();
			String elementName = (String) valueForBinding("elementName", "div", component);
			String id = _containerID(context);
			response.appendContentString("<" + elementName + " ");
			appendTagAttributeToResponse(response, "id", id);
			appendTagAttributeToResponse(response, "class", valueForBinding("class", component));
			appendTagAttributeToResponse(response, "style", valueForBinding("style", component));		
			response.appendContentString(">");
			if (hasChildrenElements()) {
				appendChildrenToResponse(response, context);
			}
			response.appendContentString("</" + elementName + ">");
	
			// Don't call super
			//super.appendToResponse(response, context);
		}
		finally {
			AjaxUpdateContainer.setCurrentUpdateContainerID(previousUpdateContainerID);
		}
	}
	
}
