package your.app.gwt;

import java.util.Iterator;

import wogwt.translatable.WOGWTClientUtil;
import wogwt.translatable.rpc.LogOnErrorAsyncCallback;
import your.app.gwt.eo.Movie;
import your.app.gwt.eo.Studio;
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
import com.webobjects.foundation.NSKeyValueCodingAdditions;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSSet;

public class RPCExampleScript implements EntryPoint {

	private Image img;
	
	private NSArray<Movie> movies;

	private TextBox txtTitle;

	//private TextBox txtStudioName;

	private ListBox lstMovies;

	private ListBox lstStudio;

	private NSArray<Studio> studios;

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
		
		lstMovies = new ListBox();
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
		
		lstStudio = new ListBox();
		flowPanel.add(lstStudio);
		
		flowPanel.add(new HTML("<br/>"));
		
		lstMovies.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				if (selectedMovie() != null) {
					txtTitle.setText(selectedMovie().title());
					
					if (selectedMovie().studio() != null) {
						lstStudio.setSelectedIndex(
							find(studios, Studio.NAME_KEY, selectedMovie().studio().name()));
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
				
				int index = find(studios, Studio.NAME_KEY, lstStudio.getItemText(lstStudio.getSelectedIndex()));
				selectedMovie().setStudioRelationship(studios.get(index));
				
				EOService.Util.getInstance().saveMovies(new NSArray(selectedMovie()), new LogOnErrorAsyncCallback<Void>() {
					public void onSuccess(Void arg0) {
						populateListBox();
						RootPanel.get().add(new HTML("Saved."));
					}
				});	
			}
		});
		flowPanel.add(btnSendBackToServer);
	}
	
	public void loadData() {		
		EOService.Util.getInstance().allMovies(
				new LogOnErrorAsyncCallback<NSArray<Movie>>() {
					public void onSuccess(NSArray<Movie> response) {
						movies = response;
						
						studios = (NSArray<Studio>) movies.valueForKeyPath(Movie.STUDIO_KEY);
						studios = new NSSet(studios).allObjects();
						
						populateScreen();
						
					}
				}
		);
	}
	
	public void populateScreen() {
		NSMutableArray<String> attributes;
		if (!movies.isEmpty()) {
			attributes = movies.get(0).attributeKeys().mutableClone();
			attributes.add("studio.name");
		} else {
			attributes = new NSMutableArray<String>();
		}
		
		populateListBox();

		for (Iterator iterator = studios.iterator(); iterator.hasNext();) {
			Studio studio = (Studio) iterator.next();
			lstStudio.addItem(studio.name());
		}
		
		img.setVisible(false);
		dataPanel.setVisible(true);
	}

	private void populateListBox() {
		lstMovies.clear();
		for (Movie movie : movies) {
			lstMovies.addItem(movie.title());
		}
	}
	
	public Movie selectedMovie() {
		int selectedIndex = lstMovies.getSelectedIndex();
		if (selectedIndex != -1)
			return movies.get(selectedIndex);
		else
			return null;
	}
	
	public int find(NSArray<? extends NSKeyValueCodingAdditions> array, String key, Object value) {
		for (int i = 0; i < array.size(); i++) {
			NSKeyValueCodingAdditions element = array.get(i);
			if (element.valueForKeyPath(key) == value ||
					element.valueForKeyPath(key).equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
}
