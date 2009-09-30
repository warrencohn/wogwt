package wogwt.translatable;

import com.google.gwt.gen2.table.client.AbstractColumnDefinition;

/**
 * A column definition that does nothing for setCellValue
 *
 * Example code:
 * 		AbstractColumnDefinition<Person, String> colName = 
 *			new ReadOnlyColumnDefinition<Person, String>("Name") {
 *			@Override
 *			public String getCellValue(Person rowValue) {
 *				return rowValue.name();
 *			}
 *		};
 *		tableDefinition.addColumnDefinition(colName);
 */
public abstract class ReadOnlyColumnDefinition<RowType, ColType> extends AbstractColumnDefinition<RowType, ColType> {

	/**
	 * @param header the text to display as the column's heading
	 */
	public ReadOnlyColumnDefinition(String header) {
		super();
		if (header != null) {
			setHeader(0, header);
		}
	}
	
	public abstract ColType getCellValue(RowType rowValue);
	
	public void setCellValue(RowType rowValue, ColType cellValue) {}
	
}
