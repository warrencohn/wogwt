package wogwt.translatable;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTMLTable.CellFormatter;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.datepicker.client.MonthSelector;

/**
 * COPIED FROM http://www.devcomments.com/Getting-the-default-DateBox-picker-to-advance-year-at-a-time-at192457.htm
 * (which was in turn copied from GWT's built in DefaultMonthSelector)
 * 
 * A simple {@link MonthSelector} used for the default date picker.
Not
 * extensible as we wish to evolve it freely over time.
 */

public  class MonthAndYearSelector extends MonthSelector {

	private static String BASE_NAME = "datePicker" ;

	private PushButton backwards;
	private PushButton forwards;
	private PushButton backwardsYear;
	private PushButton forwardsYear;
	private Grid grid;
	private int previousYearColumn = 0;
	private int previousMonthColumn = 1 ;
	private int monthColumn = 2 ;
	private int nextMonthColumn = 3;
	private int nextYearColumn = 4 ;

	@Override
	protected void refresh() {
		String formattedMonth = getModel().formatCurrentMonth();
		grid.setText(0, monthColumn, formattedMonth);
	}

	@Override
	protected void setup() {
		// Set up backwards.
		backwards = new PushButton();
		backwards.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addMonths(-1);
			}
		});

		backwards.getUpFace().setHTML("&lsaquo;");
		backwards.setStyleName(BASE_NAME + "PreviousButton");

		forwards = new PushButton();
		forwards.getUpFace().setHTML("&rsaquo;");
		forwards.setStyleName(BASE_NAME + "NextButton");
		forwards.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addMonths(+1);
			}
		});


		// Set up backwards year
		backwardsYear = new PushButton();
		backwardsYear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addMonths(-12);
			}
		});

		backwardsYear.getUpFace().setHTML("&laquo;");
		backwardsYear.setStyleName(BASE_NAME + "PreviousButton");

		forwardsYear = new PushButton();
		forwardsYear.getUpFace().setHTML("&raquo;");
		forwardsYear.setStyleName(BASE_NAME + "NextButton");
		forwardsYear.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addMonths(+12);
			}
		});

		// Set up grid.
		grid = new Grid(1, 5);
		grid.setWidget(0, previousYearColumn, backwardsYear);
		grid.setWidget(0, previousMonthColumn, backwards);
		grid.setWidget(0, nextMonthColumn, forwards);
		grid.setWidget(0, nextYearColumn, forwardsYear);

		CellFormatter formatter = grid.getCellFormatter();
		formatter.setStyleName(0, monthColumn, BASE_NAME + "Month");
		formatter.setWidth(0, previousYearColumn, "1");
		formatter.setWidth(0, previousMonthColumn, "1");
		formatter.setWidth(0, monthColumn, "100%");
		formatter.setWidth(0, nextMonthColumn, "1");
		formatter.setWidth(0, nextYearColumn, "1");
		grid.setStyleName(BASE_NAME + "MonthSelector");
		initWidget(grid);
	}

	@Override
	public void addMonths(int numMonths) {
		super.addMonths(numMonths);
	}

}
