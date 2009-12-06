package wogwt.translatable;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class ListBoxEx extends ListBox {

	/**
	 * Creates a ListBox widget that wraps an existing &lt;select&gt; element.
	 * 
	 * This element must already be attached to the document. If the element is
	 * removed from the document, you must call
	 * {@link RootPanel#detachNow(Widget)}.
	 * 
	 * @param element the element to be wrapped
	 * @return list box
	 */
	public static ListBoxEx wrap(Element element) {
		// Assert that the element is attached.
		assert Document.get().getBody().isOrHasChild(element);

		ListBoxEx listBox = new ListBoxEx(element);

		// Mark it attached and remember it for cleanup.
		listBox.onAttach();
		RootPanel.detachOnWindowClose(listBox);

		return listBox;
	}
	  
	public ListBoxEx() {
		super();
	}

	public ListBoxEx(boolean isMultipleSelect) {
		super(isMultipleSelect);
	}

	protected ListBoxEx(Element element) {
		super(element);
	}

	public List<String> getItems() {
		List<String> result = new ArrayList<String>(getItemCount());
		for (int i = 0; i < getItemCount(); i++) {
			result.add(getItemText(i));
		}
		return result;
	}
	
	public void setItems(List<String> items, List<String> values) {
		// save the selection before we clear the list
		String selectedValue = getSelectedValue();
		String selectedItemText = getSelectedItem();
		
		clear();
		
		for (int i = 0; i < items.size(); i++) {
			// add the item
			if (values != null) {
				addItem(items.get(i), values.get(i));
			} else {
				addItem(items.get(i));
			}
			
			// restore the selection
			if (isItemSelected()) {
				if (values != null) {
					if (values.get(i).equals(selectedValue)) {
						setSelectedIndex(i);
					}
				} else {
					if (items.get(i).equals(selectedItemText)) {
						setSelectedIndex(i);
					}
				}
				
			}
		}
	}
	
	public List<String> getValues() {
		List<String> result = new ArrayList<String>(getItemCount());
		for (int i = 0; i < getItemCount(); i++) {
			result.add(getValue(i));
		}
		return result;
	}
	
	public boolean isItemSelected() {
		return getSelectedIndex() != -1;
	}
	
	public String getSelectedItem() {
		if (getSelectedIndex() != -1) {
			return getItemText(getSelectedIndex());
		} else {
			return null;
		}
	}
	
	public String getSelectedValue() {
		if (getSelectedIndex() != -1) {
			return getValue(getSelectedIndex());
		} else {
			return null;
		}
	}
	
	public void setSelectedItem(String itemText) {
		for (int i = 0; i < getItemCount(); i++) {
			if (getItemText(i).equals(itemText)) {
				setSelectedIndex(i);
			}
		}
	}
	
}
