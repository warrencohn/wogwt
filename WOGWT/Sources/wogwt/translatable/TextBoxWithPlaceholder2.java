package wogwt.translatable;

import com.google.gwt.dom.client.InputElement;
import com.google.gwt.dom.client.Style.Display;
import com.google.gwt.dom.client.Style.Position;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.dom.client.Style.VerticalAlign;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.event.dom.client.MouseWheelHandler;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.BidiUtils;
import com.google.gwt.i18n.client.HasDirection;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.TextBoxBase.TextAlignConstant;

/**
 * A text box that displays a placeholder string when empty, even when focused
 * 
 * <h3>CSS Style Rules</h3>
 * <ul class='css'>
 * <li>.wogwt-TextBoxWithPlaceholder { primary style }</li>
 * <li>.wogwt-TextBoxWithPlaceholder-placeholder { style set on the the placeholder text }</li>
 * </ul>
 */
public class TextBoxWithPlaceholder2 extends Composite implements HasDirection, HasChangeHandlers, HasText, HasName, HasValue<String> {

	private static class _TextBox extends TextBox {
		public _TextBox(com.google.gwt.dom.client.Element element) {
			super(element);
		}
	}
	
	public static TextBoxWithPlaceholder2 cloneAndReplace(com.google.gwt.dom.client.Element element) {
		com.google.gwt.dom.client.Element clone = element.cloneNode(false).cast();
		
		TextBoxWithPlaceholder2 result = new TextBoxWithPlaceholder2(new _TextBox(clone));
		
		com.google.gwt.user.client.Element parent = element.getParentElement().cast();
		com.google.gwt.user.client.Element nextSibling = element.getNextSiblingElement().cast();
		
		element.removeFromParent();
		
		if (nextSibling != null) {
			DOM.insertChild(parent, result.getElement(), DOM.getChildIndex(parent, nextSibling));
		} else {
			parent.appendChild(result.getElement());
		}
		
		// Mark it attached and remember it for cleanup.
		result.onAttach();
		RootPanel.detachOnWindowClose(result);
		    
		return result;
	}
	
	private TextBox txt;
	private InlineLabel lbl;

	public TextBoxWithPlaceholder2() {
		this(new TextBox());
	}
	
	protected TextBoxWithPlaceholder2(TextBox textBox) {
		super();
		FlowPanel pnl = new FlowPanel();
		// the placeholder label will be align relative to the containing panel so it overlays the text box
		pnl.getElement().getStyle().setPosition(Position.RELATIVE); 
		pnl.getElement().getStyle().setDisplay(Display.INLINE_BLOCK);
		
		txt = textBox;
		txt.addStyleName("wogwt-TextBoxWithPlaceholder2");

		pnl.add(txt);

		lbl = new InlineLabel();
		lbl.addStyleName("wogwt-TextBoxWithPlaceholder2");
		lbl.addStyleName("wogwt-TextBoxWithPlaceholder2-placeholder");
		lbl.getElement().getStyle().setPosition(Position.RELATIVE);
		
		lbl.getElement().getStyle().setProperty("fontFamily", txt.getElement().getStyle().getProperty("fontFamily"));
		lbl.getElement().getStyle().setProperty("fontSize", txt.getElement().getStyle().getFontSize());
		lbl.getElement().getStyle().setProperty("fontWeight", txt.getElement().getStyle().getFontWeight());
		
		pnl.add(lbl);

		initWidget(pnl);

		txt.addKeyUpHandler(new KeyUpHandler() {
			public void onKeyUp(KeyUpEvent event) {
				onTextChanged();
			}
		});

		txt.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				onTextChanged();
			}
		});

		lbl.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				event.preventDefault();
				txt.setFocus(true);
			}
		});
		
		onTextChanged();
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		lbl.getElement().getStyle().setLeft(-(txt.getOffsetWidth()-4), Unit.PX);
	}
	
	private void onTextChanged() {
		if (getText().length() == 0) {
			lbl.setVisible(true);
		} else {
			lbl.setVisible(false);
		}
	}

	public void setText(String text) {
		txt.setText(text);
		onTextChanged();
	}

	public String getPlaceholder() {
		return lbl.getText();
	}

	public void setPlaceholder(String value) {
		lbl.setText(value);
	}

	// DELEGATE METHODS ////////////////////////////////////////////////
	public String getText() {
		return txt.getText();
	}

	public Direction getDirection() {
		return BidiUtils.getDirectionOnElement(txt.getElement());
	}

	/**
	 * Gets the maximum allowable length of the text box.
	 * 
	 * @return the maximum length, in characters
	 */
	public int getMaxLength() {
		return getInputElement().getMaxLength();
	}

	/**
	 * Gets the number of visible characters in the text box.
	 * 
	 * @return the number of visible characters
	 */
	public int getVisibleLength() {
		return getInputElement().getSize();
	}

	public void setDirection(Direction direction) {
		BidiUtils.setDirectionOnElement(getElement(), direction);
	}

	/**
	 * Sets the maximum allowable length of the text box.
	 * 
	 * @param length the maximum length, in characters
	 */
	public void setMaxLength(int length) {
		txt.setMaxLength(length);
	}

	/**
	 * Sets the number of visible characters in the text box.
	 * 
	 * @param length the number of visible characters
	 */
	public void setVisibleLength(int length) {
		txt.setVisibleLength(length);
	}

	private InputElement getInputElement() {
		return txt.getElement().cast();
	}

	public HandlerRegistration addChangeHandler(ChangeHandler handler) {
		return txt.addChangeHandler(handler);
	}

	public HandlerRegistration addValueChangeHandler(ValueChangeHandler<String> handler) {
		return txt.addValueChangeHandler(handler);
	}


	/**
	 * If a keyboard event is currently being handled on this text box, calling
	 * this method will suppress it. This allows listeners to easily filter
	 * keyboard input.
	 */
	public void cancelKey() {
		txt.cancelKey();
	}

	/**
	 * Gets the current position of the cursor (this also serves as the beginning
	 * of the text selection).
	 * 
	 * @return the cursor's position
	 */
	public int getCursorPos() {
		return txt.getCursorPos();
	}

	public String getName() {
		return txt.getName();
	}

	/**
	 * Gets the text currently selected within this text box.
	 * 
	 * @return the selected text, or an empty string if none is selected
	 */
	public String getSelectedText() {
		return txt.getSelectedText();
	}

	/**
	 * Gets the length of the current text selection.
	 * 
	 * @return the text selection length
	 */
	public int getSelectionLength() {
		return txt.getSelectionLength();
	}

	public String getValue() {
		return getText();
	}

	public boolean isReadOnly() {
		return txt.isReadOnly();
	}

	/**
	 * Selects all of the text in the box.
	 * 
	 * This will only work when the widget is attached to the document and not
	 * hidden.
	 */
	public void selectAll() {
		txt.selectAll();
	}

	/**
	 * Sets the cursor position.
	 * 
	 * This will only work when the widget is attached to the document and not
	 * hidden.
	 * 
	 * @param pos the new cursor position
	 */
	public void setCursorPos(int pos) {
		txt.setCursorPos(pos);
	}

	public void setName(String name) {
		txt.setName(name);
	}

	/**
	 * Turns read-only mode on or off.
	 * 
	 * @param readOnly if <code>true</code>, the widget becomes read-only; if
	 *          <code>false</code> the widget becomes editable
	 */
	public void setReadOnly(boolean readOnly) {
		txt.setReadOnly(readOnly);
	}

	/**
	 * Sets the range of text to be selected.
	 * 
	 * This will only work when the widget is attached to the document and not
	 * hidden.
	 * 
	 * @param pos the position of the first character to be selected
	 * @param length the number of characters to be selected
	 */
	public void setSelectionRange(int pos, int length) {
		txt.setSelectionRange(pos, length);
	}

	/**
	 * Sets the alignment of the text in the text box.
	 * 
	 * @param align the text alignment (as specified by {@link #ALIGN_CENTER},
	 *          {@link #ALIGN_JUSTIFY}, {@link #ALIGN_LEFT}, and
	 *          {@link #ALIGN_RIGHT})
	 */
	public void setTextAlignment(TextAlignConstant align) {
		txt.setTextAlignment(align);
	}

	public void setValue(String value) {
		txt.setValue(value);
	}

	public void setValue(String value, boolean fireEvents) {
		txt.setValue(value, fireEvents);
	}

	public HandlerRegistration addBlurHandler(BlurHandler handler) {
		return txt.addBlurHandler(handler);
	}

	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return txt.addClickHandler(handler);
	}

	public HandlerRegistration addFocusHandler(FocusHandler handler) {
		return txt.addFocusHandler(handler);
	}

	public HandlerRegistration addKeyDownHandler(KeyDownHandler handler) {
		return txt.addKeyDownHandler(handler);
	}

	public HandlerRegistration addKeyPressHandler(KeyPressHandler handler) {
		return txt.addKeyPressHandler(handler);
	}

	public HandlerRegistration addKeyUpHandler(KeyUpHandler handler) {
		return txt.addKeyUpHandler(handler);
	}

	public HandlerRegistration addMouseDownHandler(MouseDownHandler handler) {
		return txt.addMouseDownHandler(handler);
	}

	public HandlerRegistration addMouseMoveHandler(MouseMoveHandler handler) {
		return txt.addMouseMoveHandler(handler);
	}

	public HandlerRegistration addMouseOutHandler(MouseOutHandler handler) {
		return txt.addMouseOutHandler(handler);
	}

	public HandlerRegistration addMouseOverHandler(MouseOverHandler handler) {
		return txt.addMouseOverHandler(handler);
	}

	public HandlerRegistration addMouseUpHandler(MouseUpHandler handler) {
		return txt.addMouseUpHandler(handler);
	}

	public HandlerRegistration addMouseWheelHandler(MouseWheelHandler handler) {
		return txt.addMouseWheelHandler(handler);
	}

	/**
	 * Gets the tab index.
	 * 
	 * @return the tab index
	 */
	 public int getTabIndex() {
		return txt.getTabIndex();
	 }

	 /**
	  * Gets whether this widget is enabled.
	  * 
	  * @return <code>true</code> if the widget is enabled
	  */
	 public boolean isEnabled() {
		 return txt.isEnabled();
	 }

	 public void setAccessKey(char key) {
		 txt.setAccessKey(key);
	 }

	 /**
	  * Sets whether this widget is enabled.
	  * 
	  * @param enabled <code>true</code> to enable the widget, <code>false</code>
	  *          to disable it
	  */
	 public void setEnabled(boolean enabled) {
		 txt.setEnabled(enabled);
	 }

	 public void setFocus(boolean focused) {
		 txt.setFocus(focused);
	 }

	 public void setTabIndex(int index) {
		 txt.setTabIndex(index);
	 }
}
