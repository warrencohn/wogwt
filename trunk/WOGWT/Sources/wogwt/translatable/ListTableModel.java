package wogwt.translatable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.google.gwt.gen2.table.client.TableModel;
import com.google.gwt.gen2.table.client.TableModelHelper.ColumnSortInfo;
import com.google.gwt.gen2.table.client.TableModelHelper.Request;
import com.google.gwt.gen2.table.client.TableModelHelper.Response;

/**
 * Does paging, sorting, and filtering when a java.util.List is used for the table model.
 * Used with PagingScrollTable
 */
public class ListTableModel<RowType> extends TableModel<RowType> {
	
	private List<RowType> list;
	private List<RowType> filteredList;
	private TableComparator<RowType> comparator;
	private TableFilterer<RowType> filterer;
	private int filterColumn = -1;
	private Object filter = null;
	
	/**
	 * 
	 * @param list
	 * @param comparator may be null
	 * @param filterer may be null
	 */
	public ListTableModel(List<RowType> list, TableComparator<RowType> comparator, TableFilterer<RowType> filterer) {
		if (list == null) {
			throw new IllegalArgumentException("list may not be null");
		}
		
		this.list = list;
		this.filteredList = list;
		this.comparator = comparator;
		this.filterer = filterer;
	}
	
	private static <T> List<T> subList(List<T> list, int fromIndex, int toIndex) {
		// See http://code.google.com/p/google-web-toolkit/issues/detail?id=1791
		// this implementation only runs fast in javascript code,
		// since all list implementations in GWT use javascript arrays, which
		// are random access
		ArrayList<T> ret = new ArrayList<T>();
		for (int i = fromIndex; i < toIndex && i < list.size(); i++) {
			ret.add(list.get(i));
		}
		return ret;
	}
	  
	@Override
	public void requestRows(Request request, Callback<RowType> callback) {
		if (request.getStartRow() < 0 || request.getStartRow() > (filteredList.size()-1)) {
			//callback.onFailure(new IndexOutOfBoundsException("Index out of bounds exception - Index: " + request.getStartRow() + ", Size: " + filteredList.size()));
			callback.onRowsReady(request, new Response<RowType>() {
				@Override
				public Iterator<RowType> getRowValues() {
					return new ArrayList<RowType>().iterator();
				}
			});
			return;
		}
		
		final List<RowType> subList = subList(filteredList, request.getStartRow(), request.getStartRow() + request.getNumRows());
		
		if (request.getColumnSortList().getPrimaryColumnSortInfo() != null && comparator != null) {
			comparator.setSortInfo(request.getColumnSortList().getPrimaryColumnSortInfo());
			Collections.sort(subList, comparator);
			if (!request.getColumnSortList().isPrimaryAscending()) {
				Collections.reverse(subList);
			}
		}
		
		callback.onRowsReady(request, new Response<RowType>() {
			@Override
			public Iterator<RowType> getRowValues() {
				return subList.iterator();
			}
		});
	}
	
	@Override
	public int getRowCount() {
		return filteredList.size();
	}
	
	protected int getFilterColumn() {
		return this.filterColumn;
	}
	
	protected Object getFilter() {
		return this.filter;
	}
	
	public void setFilter(int column, Object filter) {
		this.filterColumn = column;
		this.filter = filter;
		applyFilter();
	}
	
	protected void applyFilter() {
		if (filterer == null || filterColumn == -1 || filter == null) {
			filteredList = list;
			return;
		}
		
		List<RowType> result = new ArrayList<RowType>();
		
		for (int i = 0; i < list.size(); i++) {
			RowType row = list.get(i);
			if (filterer.matches(row, filterColumn, filter)) {
				result.add(row);
			}
		}
		
		filteredList = result; // assign at the end since we're allowing user code to run in between - prevent partial result if an exception is thrown
	}

	/**
	 * Example Code:
	 * 	private static class PersonComparator extends ListTableModel.TableComparator<Person> {
	 *		public int compare(Person left, Person right) {
	 *			switch (getSortInfo().getColumn()) {
	 *				case 0:
	 *					return left.id().compareTo(right.id());
	 *				case 1:
	 *					return left.name().compareTo(right.name());
	 *				default:
	 *					throw new RuntimeException("Invalid column index");
	 *			}
	 *		}
	 *	}
	 */
	public static abstract class TableComparator<RowType> implements Comparator<RowType> {
		private ColumnSortInfo sortInfo;
		
		public ColumnSortInfo getSortInfo() {
			return this.sortInfo;
		}
		
		private void setSortInfo(ColumnSortInfo sortInfo) {
			this.sortInfo = sortInfo;
		}
		
		/**
		 * Just like the regular compare method in Comparator, but
		 * gives you access to the sortInfo via: 
		 * getSortInfo().getColumn() and 
		 * getSortInfo().isAscending
		 */
		public abstract int compare(RowType o1, RowType o2);
	}

	/**
	 * Example Code:
	 * 	private static class PersonFilterer implements ListTableModel.TableFilterer<Person> {
	 *		public boolean matches(Person row, int column, Object filter) {
	 *			switch (column) {
	 *				case 0:
	 *					return row.id().equals((String)filter);
	 *				case 1:
	 *					return row.name().toLowerCase().contains(((String)filter).toLowerCase());
	 *				default:
	 *					throw new RuntimeException("Invalid column index");
	 *			}
	 *		}
	 *	}
	 */
	public static interface TableFilterer<RowType> {
		public boolean matches(RowType row, int column, Object filter);
	}
	
}