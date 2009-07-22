package wogwt.translatable;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.ListBox;

public class ListBoxEx extends ListBox {

	public ListBoxEx() {
		super();
	}

	public ListBoxEx(boolean isMultipleSelect) {
		super(isMultipleSelect);
	}

	public ListBoxEx(Element element) {
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
