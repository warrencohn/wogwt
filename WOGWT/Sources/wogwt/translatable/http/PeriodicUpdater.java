package wogwt.translatable.http;


import com.google.gwt.user.client.Timer;

/** 
 * This class will do an ajax request every X milliseconds to the url specified 
 * by the updateContainer's "updateUrl" attribute and replace the contents of 
 * the updateContainer with the response.
 * 
 * To use this, your WOComponent should have something like this:
 * 
 * 		PeriodicUpdateContainer : WOGenericContainer {
 *			invokeAction = yourAction;
 *			updateUrl = context.componentActionURL;
 *			elementName = "div";
 *			id = "yourid"; 
 *		}
 *
 */
public class PeriodicUpdater extends Updater {

	private Timer timer;
	private int frequencyInMilliseconds;
	
	public PeriodicUpdater(String updateContainerID, int frequencyInMilliseconds) {
		super(updateContainerID);
		this.frequencyInMilliseconds = frequencyInMilliseconds;
		setupTimer();
	}

	public PeriodicUpdater(String updateContainerID, int frequencyInMilliseconds, AfterDOMUpdateCallback callback) {
		super(updateContainerID, callback);
		this.frequencyInMilliseconds = frequencyInMilliseconds;
		setupTimer();
	}
	
	protected void setupTimer() {
		new Timer() {
			public void run() {
				timer = new Timer() {
					public void run() {
						fireUpdate();
					}
				};
				timer.scheduleRepeating(getFrequencyInMilliseconds());
			}
		}.schedule(getFrequencyInMilliseconds());
	}
		
	/**
	 * Ends the periodic update.
	 */
	public void cancel() {
		timer.cancel();
	}
	
	/**
	 * Restarts the periodic update.
	 */
	public void restart() {
		timer.cancel();
		setupTimer();
	}
	
	protected Timer getTimer() {
		return timer;
	}
	
	protected int getFrequencyInMilliseconds() {
		return frequencyInMilliseconds;
	}
}
