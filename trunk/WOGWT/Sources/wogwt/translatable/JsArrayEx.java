package wogwt.translatable;

import java.util.Comparator;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class JsArrayEx<T extends JavaScriptObject> extends JsArray<T> {

	protected JsArrayEx() {
	}
	
	public final int size() {
		return length();
	}
	
	public final boolean isEmpty() {
		return length() == 0;
	}
	
	public final void add(T object) {
		push(object);
	}
	
	/**
	 * TODO: support var-args
	 * Joins two or more arrays and returns the result
	 * @param otherArray
	 * @return a single array containing all the elements from all the arrays passed in
	 */
	public final native JsArrayEx<T> concat(JsArray<T> otherArray) /*-{
		return this.concat(otherArray);
	}-*/;
	
	/**
	 * Puts all the elements of an array into a string. The elements are separated by a specified delimiter
	 * @param separator
	 * @return string with each element separated by the delimiter
	 */
	public final native String join(String delimiter) /*-{
		return this.join(delimiter);
	}-*/;

	/**
	 * Removes and returns the last element of an array
	 * @return the last element of an array
	 */
	public final native T pop() /*-{
		return this.pop();
	}-*/;

	/**
	 * Reverses the order of the elements in an array
	 */
	public final native void reverse() /*-{
		this.reverse();
	}-*/;

	/**
	 * Selects all elements from the specified start position and to the end of the array
	 * @param start
	 * @return all elements from the specified start position and to the end of the array
	 */
	public final native JsArrayEx<T> slice(int start) /*-{
		return this.slice(start);
	}-*/;
	
	/**
	 * Selects elements from an array
	 * @param start
	 * @param end exclusive
	 * @return selected elements from the array.
	 */
	public final native JsArrayEx<T> slice(int start, int end) /*-{
		return this.slice(start, end);
	}-*/;
	
	/**
	 * Will sort the elements alphabetically
	 */
	public final native void sort() /*-{
		this.sort();
	}-*/;
	
	// TODO: implement sort that allows passing in a java Comparator
	/**
	 * The sort() method will sort the elements alphabetically by default.
	 */
	public final native void sort(Comparator<T> comparator) /*-{
		this.sort(function(a, b) {
			return comparator.@java.util.Comparator::compare(Ljava/lang/Object;Ljava/lang/Object;)(a, b);
		});
	}-*/;
	
	/**
	 * TODO: implement additional method that takes a var-args number of elements to insert
	 * Used to remove and add new elements to an array
	 */
	public final native void splice(int index, int numberToRemove) /*-{
		this.splice(index, numberToRemove);
	}-*/;
	
	/**
	 * TODO: support var-args
	 * Adds one or more elements to the beginning of an array
	 * @param newElement
	 * @return the new length
	 */
	public final native int unshift(T newElement) /*-{
		return this.unshift(newElement);
	}-*/;
	
}
