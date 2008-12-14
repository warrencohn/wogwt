package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.rpc.LogOnErrorAsyncCallback;
import your.app.gwt.eo.MovieClient;
import your.app.gwt.eo.StudioClient;
import your.app.gwt.rpc.EOService;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.webobjects.foundation.NSArray;

public class TreeExampleScript implements EntryPoint {

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("TreeExample")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		final Tree tree = new Tree();
		
		EOService.Util.getInstance().allStudios(
				new LogOnErrorAsyncCallback<NSArray<StudioClient>>() {
					public void onSuccess(NSArray<StudioClient> response) {
						Image imgLoading = Image.wrap(DOM.getElementById("imgLoading"));
						imgLoading.setVisible(false);
						
						for (int studioIdx = 0; studioIdx < response.size(); studioIdx++) {
							StudioClient studio = (StudioClient)response.get(studioIdx);
							TreeItem item = new TreeItem(studio.name());
							tree.addItem(item);
							
							Tree childTree = new Tree();
							for (int movieIdx = 0; movieIdx < studio.movies().size(); movieIdx++) {
								MovieClient movie = (MovieClient)studio.movies().get(movieIdx);
								TreeItem childItem = new TreeItem(movie.title());
								childTree.addItem(childItem);
							}
							item.addItem(childTree);
						}
					}
		});
		RootPanel.get("container").add(tree);
	}
	
}
