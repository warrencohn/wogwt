package your.app.gwt;

import java.util.List;

import wogwt.translatable.ListBoxEx;
import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.rpc.LogOnErrorAsyncCallback;
import your.app.gwt.eo.MovieClient;
import your.app.gwt.eo.StudioClient;
import your.app.gwt.rpc.EOService;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.gen2.logging.shared.Log;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.InlineLabel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSComparator;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSSet;
import com.webobjects.foundation.NSComparator.ComparisonException;

public class RPCExampleScript implements EntryPoint {

	private Image img;
	
	private NSArray<MovieClient> movies;

	private TextBox txtTitle;

	//private TextBox txtStudioName;

	private ListBoxEx lstMovies;

	private ListBoxEx lstStudio;

	private NSArray<StudioClient> studios;

	private HorizontalPanel dataPanel;
	
	/* This class must be declared as an entry-point in the module. */
	public void onModuleLoad() {
		if (!WOGWTClientUtil.hostPageNameEquals("RPCExample")) {
			return;
		}
		
		Log.finest(getClass().getName() + ": onModuleLoad");
		
		Log.installUncaughtExceptionHandler();
		
		Anchor link = new Anchor("Load");
		link.addClickListener(new ClickListener() {
			public void onClick(Widget sender) {
				img.setVisible(true);
				try {
					loadData();
				} catch (Exception e) {
					e.printStackTrace();
					Log.severe(e.getMessage());
				}
			}
		});
		
		img = new Image(WOGWTClientUtil.resourceUrl() + "wait18.gif");
		img.setVisible(false);
		
		RootPanel.get("rpcContent").add(link);
		RootPanel.get("rpcContent").add(img);
		RootPanel.get("rpcContent").add(new HTML("<br/>"));
		

		dataPanel = new HorizontalPanel();
		dataPanel.setWidth("100%");
		dataPanel.setVisible(false);
		RootPanel.get("rpcContent").add(dataPanel);
		
		lstMovies = new ListBoxEx();
		lstMovies.setVisibleItemCount(20);
		dataPanel.add(lstMovies);
		
		FlowPanel flowPanel = new FlowPanel();
		flowPanel.setWidth("100%");
		flowPanel.getElement().setId("rpcForm");
		dataPanel.add(flowPanel);
		
		flowPanel.add(new InlineLabel("Title: "));
		txtTitle = new TextBox();
		flowPanel.add(txtTitle);
		flowPanel.add(new HTML("<br/>"));
		
		flowPanel.add(new InlineLabel("Studio: "));
		
		lstStudio = new ListBoxEx();
		flowPanel.add(lstStudio);
		
		flowPanel.add(new HTML("<br/>"));
		
		lstMovies.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if (selectedMovie() != null) {
					txtTitle.setText(selectedMovie().title());
					
					if (selectedMovie().studio() != null) {
						lstStudio.setSelectedIndex(
							find(studios, StudioClient.NAME_KEY, selectedMovie().studio().name()));
					} else {
						//txtStudioName.setText("");
					}
				}
			}
		});
		
		Button btnSendBackToServer = new Button("Save");
		btnSendBackToServer.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (selectedMovie() == null) {
					return;
				}
				
				selectedMovie().setTitle(txtTitle.getText().equals("") ? null : txtTitle.getText());
				//selectedMovie().studio().setName(txtStudioName.getText().equals("") ? null : txtStudioName.getText());
				
				int index = find(studios, StudioClient.NAME_KEY, lstStudio.getSelectedItem());
				selectedMovie().setStudio(studios.get(index));
				
//				EOService.Util.getInstance().saveMovies(new NSArray(selectedMovie()), new LogOnErrorAsyncCallback<Void>() {
//					public void onSuccess(Void arg0) {
//						populateListBox();
//						RootPanel.get().add(new HTML("Saved."));
//					}
//				});	
			}
		});
		flowPanel.add(btnSendBackToServer);
	}
	
	public void loadData() {	
		EOService.Util.getInstance().allMovies(new LogOnErrorAsyncCallback<NSArray<MovieClient>>() {
			public void onSuccess(NSArray<MovieClient> response) {
				movies = response;
				
				NSArray<StudioClient> studiosWithDuplicates = (NSArray<StudioClient>) movies.valueForKey(MovieClient.STUDIO_KEY);
				studios = new NSSet(studiosWithDuplicates).allObjects();
				
				populateScreen();
			}
		});
	}
	
	public void populateScreen() {
		NSMutableArray<String> attributes;
		if (movies.size() != 0) {
			attributes = movies.get(0).attributeKeys().mutableClone();
			attributes.add("studio.name");
		} else {
			attributes = new NSMutableArray<String>();
		}
		
		populateListBox();

		NSArray<String> studioNames = (NSArray<String>) studios.valueForKey(StudioClient.NAME_KEY);
		
		try {
			studioNames = studioNames.sortedArrayUsingComparator(NSComparator.AscendingCaseInsensitiveStringComparator);
		} catch (ComparisonException e) {
			Log.severe(e.getMessage());
		}
		
		lstStudio.setItems(studioNames, null);
		
		img.setVisible(false);
		dataPanel.setVisible(true);
	}

	private void populateListBox() {
		lstMovies.clear();
		NSArray<String> movieTitles = (NSArray<String>) movies.valueForKey(MovieClient.TITLE_KEY);
		lstMovies.setItems(movieTitles, null);
	}
	
	public MovieClient selectedMovie() {
		int selectedIndex = lstMovies.getSelectedIndex();
		if (selectedIndex != -1)
			return movies.get(selectedIndex);
		else
			return null;
	}
	
	public int find(List<StudioClient> array, String key, Object value) {
		for (int i = 0; i < array.size(); i++) {
			StudioClient element = array.get(i);
			if (element.valueForKey(key) == value ||
					element.valueForKey(key).equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
}
