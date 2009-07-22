package wogwt.translatable;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;

public abstract class AbstractEntryPoint implements EntryPoint {

	public void onModuleLoad() {
		Log.installUncaughtExceptionHandler();
		
		DeferredCommand.addCommand(new Command() {
			public void execute() {
				init();				
			}
		});
	}

	public abstract void init();
	
}
