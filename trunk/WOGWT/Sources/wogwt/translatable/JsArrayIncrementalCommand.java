package wogwt.translatable;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.IncrementalCommand;

public abstract class JsArrayIncrementalCommand<T extends JavaScriptObject> implements IncrementalCommand {

	private int index = 0;
	private final int batch;
	private final JsArray<T> array;
	
	public JsArrayIncrementalCommand(JsArray<T> array) {
		this(array, 1);
	}
	
	public JsArrayIncrementalCommand(JsArray<T> array, int batch) {
		super();
		this.array = array;
		this.batch = batch;
	}
	
	public boolean execute() {
		if (array.length() > 0) {
			for (int i = 0; i < batch; i++) {
				execute(array.get(index), index);
				index++;
			}
		}
		return index < array.length();
	}
	
	public abstract void execute(T element, int index);
	
}
