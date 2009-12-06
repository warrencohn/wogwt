package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.rpc.AlertOnErrorAsyncCallback;
import your.app.gwt.eo.MovieClient;
import your.app.gwt.eo.StudioClient;
import your.app.gwt.rpc.EOService;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.OpenEvent;
import com.google.gwt.event.logical.shared.OpenHandler;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.webobjects.foundation.NSArray;

public class TreeExampleScript implements EntryPoint {

	private Tree tree;
	private NSArray<StudioClient> studios;

	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("TreeExample")) {
			return;
		}
		
		Log.finest(getClass().getName() + ": onModuleLoad");
		
		tree = new Tree();
		
		fetchStudios();

		RootPanel.get("container").add(tree);
	}

	private void fetchStudios() {
		EOService.Util.getInstance().allStudios(new AlertOnErrorAsyncCallback<NSArray<StudioClient>>() {
			public void onSuccess(NSArray<StudioClient> response) {
				Image imgLoading = Image.wrap(DOM.getElementById("imgLoading"));
				imgLoading.setVisible(false);
				
				studios = response;
				createMasterTree();	
			}
		});
	}
	
	private void createMasterTree() {
		for (int studioIdx = 0; studioIdx < studios.size(); studioIdx++) {
			StudioClient studio = studios.get(studioIdx);
			TreeItem item = new TreeItem(studio.name());
			tree.addItem(item);
			
			TreeItem placeholder = new TreeItem("Loading...");
			item.addItem(placeholder);
		}
		
		tree.addOpenHandler(new OpenHandler<TreeItem>() {
			public void onOpen(OpenEvent<TreeItem> event) {
				onStudioOpened(event.getTarget());
			}
		});
	}
	
	private void onStudioOpened(TreeItem openedItem) {
		if (openedItem.getChildCount() == 1 && openedItem.getChild(0).getHTML().equals("Loading...")) {
			for (int i = 0; i < tree.getItemCount(); i++) {
				if (tree.getItem(i).equals(openedItem)) {
					addMoviesToTree(openedItem, studios.get(i).movies());
					break;
				}
			}
		}
	}
	
	private void addMoviesToTree(final TreeItem parentItem, NSArray<MovieClient> movies) {
		parentItem.removeItems();
		for (int movieIdx = 0; movieIdx < movies.size(); movieIdx++) {
			MovieClient movie = movies.get(movieIdx);
			TreeItem childItem = new TreeItem(movie.title());
			parentItem.addItem(childItem);
		}
	}
	
}
