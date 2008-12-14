package your.app.gwt;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.rpc.LogOnErrorAsyncCallback;
import your.app.gwt.eo.MovieClient;
import your.app.gwt.rpc.EOService;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.webobjects.foundation.NSArray;

public class RPCExampleScript implements EntryPoint {

	public static final String gridContainerID = "gridContainer";
	
	private Image img;
	private Grid grid;
	
	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("RPCExample")) {
			return;
		}
		
		Log.debug(getClass().getName() + ": onModuleLoad");
		
		final RootPanel panel = RootPanel.get(gridContainerID);
		
		Anchor link = new Anchor("Load");
		link.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				if (grid != null)
					grid.setVisible(false);
				img.setVisible(true);
				loadData();
			}
		});
		
		img = new Image(WOGWTClientUtil.resourceUrl() + "wait18.gif");
		img.setVisible(false);
		
		panel.add(link);
		panel.add(img);
	}
	
	public void loadData() {
		EOService.Util.getInstance().allMovies(
				new LogOnErrorAsyncCallback<NSArray<MovieClient>>() {
					public void onSuccess(NSArray<MovieClient> response) {
						populateScreen(response);
					}
				}
		);
	}
	
	public void populateScreen(NSArray<MovieClient> objects) {
		RootPanel panel = RootPanel.get(gridContainerID);

		NSArray<String> attributes = MovieClient.attributeKeys();

		boolean createGrid = (grid == null);
		if (createGrid) {
			grid = new Grid(objects.size()+1, attributes.size());
			grid.setBorderWidth(1);
			grid.addStyleName("dataTable");
		}
		
		for (int col = 0; col < attributes.size(); ++col) {
			String key = (String)attributes.get(col);
			grid.setText(0, col, key);
		}
		grid.getRowFormatter().addStyleName(0, "header");
		
		for (int row = 0; row < objects.size(); ++row) {
			MovieClient eo = (MovieClient)objects.get(row);
			for (int col = 0; col < attributes.size(); ++col) {
				String key = (String)attributes.get(col);
				String value = null;
				if (eo.valueForKey(key) != null) {
					grid.setText(row+1, col, eo.valueForKey(key).toString());
				}
			}
		}
		
		if (createGrid)
			panel.add(grid);
		
		img.setVisible(false);
		grid.setVisible(true);
	}
	
}
