package wogwt.translatable;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * A dialog box with a title bar that says "Error" and an OK button,
 * with an area for the error message text in the middle.
 *
 */
public class ErrorDialog extends DialogBox {

	public ErrorDialog(String message) {
		super(false, true);

		setText("Error");

		VerticalPanel panel = new VerticalPanel();
		panel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		
		Label label = new Label(message);
		panel.add(label);
		
		Button okButton = new Button("OK");
		okButton.setWidth("100px");
		okButton.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				ErrorDialog.this.hide();
			}
		});
		panel.add(okButton);
		
		setWidget(panel);
		
		setWidth("300px");
		setHeight("250px");
	}

	public void showModal() {
		setPopupPositionAndShow(new PopupPanel.PositionCallback() {
			public void setPosition(int offsetWidth, int offsetHeight) {
				center();
			}
		});
	}
}
