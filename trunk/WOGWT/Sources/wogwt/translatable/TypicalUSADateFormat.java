package wogwt.translatable;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

/**
 * A format for DateBox that FORMATS dates with a 4 digit year ("MM/dd/yyyy"),
 * but PARSES using a 2 digit year ("MM/dd/yy")
 *
 */
public class TypicalUSADateFormat extends DefaultFormat {

	/**
	 * Copied from DateBox
	 */
	private static final String DATE_BOX_FORMAT_ERROR = "dateBoxFormatError";
	
	/* used for parsing.  the formatter in the constructor is used for formatting */
	private DateTimeFormat parser = DateTimeFormat.getFormat("MM/dd/yy");
	
	public TypicalUSADateFormat() {
		super(DateTimeFormat.getFormat("MM/dd/yyyy"));
	}

	/**
	 * Copied from DateBox.DefaultFormat and changed to use 'parser'
	 */
	@Override
	public Date parse(DateBox dateBox, String dateText, boolean reportError) {
	      Date date = null;
	      try {
	        if (dateText.length() > 0) {
	          date = parser.parse(dateText);
	        }
	      } catch (IllegalArgumentException exception) {
	        try {
	          date = new Date(dateText);
	        } catch (IllegalArgumentException e) {
	          if (reportError) {
	            dateBox.addStyleName(DATE_BOX_FORMAT_ERROR);
	          }
	          return null;
	        }
	      }
	      return date;
	}
	
}
