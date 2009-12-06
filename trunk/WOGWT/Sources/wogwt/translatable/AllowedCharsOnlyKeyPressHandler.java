package wogwt.translatable;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.Window;

public class AllowedCharsOnlyKeyPressHandler implements KeyPressHandler {

	private String allowedChars;
	
	public AllowedCharsOnlyKeyPressHandler(String allowedChars) {
		this.allowedChars = allowedChars;
	}

	public void onKeyPress(KeyPressEvent event) {
		if (!event.isControlKeyDown() && !event.isMetaKeyDown()) {
			if (!allowedChars.contains(event.getCharCode() + "") && 
					!DigitOnlyKeyPressHandler.isNavigationOrModifierKey(event.getCharCode())) {
				event.preventDefault();
			} else if (!allowedChars.contains(event.getCharCode() + "") && 
					event.isShiftKeyDown() && 
					event.getCharCode() != KeyCodes.KEY_TAB) {
				event.preventDefault();
			}
		}
	}

}
