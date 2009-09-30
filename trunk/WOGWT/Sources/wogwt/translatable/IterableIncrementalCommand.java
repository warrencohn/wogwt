package wogwt.translatable;

import java.util.Iterator;

import com.google.gwt.core.client.JsArray;
import com.google.gwt.user.client.IncrementalCommand;

public abstract class IterableIncrementalCommand<T> implements IncrementalCommand {

	private int index = 0;
	private final int batch;
	private final Iterator<T> iterator;
	
	public IterableIncrementalCommand(Iterable<T> iterable) {
		this(iterable, 1);
	}
	
	public IterableIncrementalCommand(Iterable<T> iterable, int batch) {
		super();
		this.iterator = iterable.iterator();
		this.batch = batch;
	}
	
	public boolean execute() {
		index = 0;
		while (iterator.hasNext() && index < batch) {
			execute(iterator.next());
			index++;
		}
		return iterator.hasNext();
	}
	
	public abstract void execute(T element);
	
}
