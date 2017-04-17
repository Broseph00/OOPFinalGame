package com.iteration3.view;

import com.iteration3.model.Map.Location;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Created by LesliesLaptop on 4/14/17.
 */
public class GameWindow extends VBox implements View {
    private MenuBar menuBar;
    private TabPane tabPane;
    private MainView mainView;
    private WonderView wonderView;

    public GameWindow(double width, double height, int wonderRows) {
        this.menuBar = new MenuBar();
        this.tabPane = new TabPane();
        this.mainView = new MainView(width, height);
        this.wonderView = new WonderView(width, height, wonderRows);
        tabPane.setFocusTraversable(false);
        this.setFocusTraversable(true);
 
        initializeMenuBar();
        initializeTabs();
        this.setFocusTraversable(true);

    }

    private void initializeMenuBar() {
        getMenuBar().prefWidthProperty().bind(this.widthProperty());

        Menu fileMenu = new Menu("File");
//        MenuItem newMap = new MenuItem("Create New Map");
//        importMapFileItem = new MenuItem("Import Map File...");
//        exportMapFileItem = new MenuItem("Export Map File...");
//        fileMenu.getItems().add(newMap);
//        fileMenu.getItems().add(importMapFileItem);
//        fileMenu.getItems().add(exportMapFileItem);
        getMenuBar().getMenus().add(fileMenu);

        this.getChildren().add(getMenuBar());
    }

    private void initializeTabs() {
        Tab mainViewTab = new Tab("Main View");
        Tab wonderViewTab = new Tab("Wonder View");

        mainViewTab.setContent(getMainView());
        wonderViewTab.setContent(getWonderView());

        getTabPane().getTabs().addAll(mainViewTab, wonderViewTab);
        getTabPane().setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        this.getChildren().add(getTabPane());
    }
    
    public MainView getMainView() {
        return mainView;
    }

    public WonderView getWonderView() {
        return wonderView;
    }

    public TabPane getTabPane() {
        return tabPane;
    }
    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void drawTile(String imageURL, int x, int y) {
        getMainView().drawTile(imageURL, x, y);
    }
    public void drawPreviewImage(String imageURL) {
        getMainView().drawPreviewImage(imageURL);
    }
    public void clearPreviewImage() { getMainView().clearPreviewImage(); }
    public void drawRiver(String imageURL, int x, int y) {
        getMainView().drawRiver(imageURL, x, y);
    }
    public void drawTransport(String imageURL, int x, int y, int region){getMainView().drawTransport(imageURL, x, y, region);}
    public void drawResource(String imageURL, int x, int y, int region){getMainView().drawResource(imageURL, x, y, region);}
	public void drawProducer(String imageURL, int x, int y, int region){getMainView().drawProducer(imageURL, x, y, region);}
	public void drawBigResource(String imageURL, int region) {getMainView().drawBigResource(imageURL, region);}
	public void drawBigTransport(String imageURL, int region) {getMainView().drawBigTransport(imageURL, region);};
	public void drawBigProducer(String imageURL, int region) {getMainView().drawBigProducer(imageURL, region);};


	public Location getCursorLocation() {
        return mainView.getCursorLocation();
    }

    public void addKeyHandler(EventHandler <KeyEvent> handler) {
        this.setOnKeyPressed(handler);
    }

    @Override
    public void update() {
        getMainView().update();
    }
    
    public void setEnableMoveButton(Boolean isEnabled){
		mainView.setEnableMoveButton(isEnabled);
	}
	
	public void setCurrentTransporter(String currentTransporter) {
		mainView.setCurrentTransporter(currentTransporter);
	}
	
	public void setOnMoveButton(EventHandler<ActionEvent> handler) {
		mainView.setOnMoveButton(handler);
	}
	
	public void setOnClickEndMovementTurn(EventHandler<ActionEvent> handler) {
		mainView.setOnClickEndMovementTurn(handler);
	}
	
	public void setEnableFactoryButton(Boolean isEnabled){
		mainView.setEnableFactoryButton(isEnabled);
	}
	
	public void setOnClickFactoryButton(EventHandler<ActionEvent> handler) {
		mainView.setOnClickFactoryButton(handler);
	}
	
	public void setOnClickEndProductionTurn(EventHandler<ActionEvent> handler) {
		mainView.setOnClickEndProductionTurn(handler);
	}
	
	public void highlightTransportOption() {
		mainView.highlightTransportOption();
	}
	
	public void highlightMovementOption() {
		mainView.highlightMovementOption();
	}
	
	public void swapToProductionView() {
        mainView.swapToProductionView();
    }
    
    public void swapToMovementView() {
    	mainView.swapToMovementView();
    }
    

	public void setEnablePickUpResourceButton(Boolean isEnabled){
		mainView.setEnablePickUpResourceButton(isEnabled);
	}
	
	public void setEnableDropResourceButton(Boolean isEnabled){
		mainView.setEnableDropResourceButton(isEnabled);
	}
	
	public void setCurrentTileResource(String resource) {
		mainView.setCurrentTileResource(resource);
	}
	
	public void setCurrentTransportResource(String resource) {
		mainView.setCurrentTransportResource(resource);
	}
	
	
	public void setOnClickPickUpResource(EventHandler<ActionEvent> handler) {
		mainView.setOnClickPickUpResource(handler);
	}
	
	public void setOnClickDropResource(EventHandler<ActionEvent> handler) {
		mainView.setOnClickDropResource(handler);
	}
	
	public void setMovementOption(String movementOption) {
		mainView.setMovementOption(movementOption);
	}
	
	public void highlightBuildingOption() {
		mainView.highlightBuildingOption();
	}
	
	public void setEnableBuildButton(Boolean isEnabled){
		mainView.setEnableBuildButton(isEnabled);
	}
	
	public void setTileResourceList(String list) {
		mainView.setTileResourceList(list);
	}
	
	public void setTransportResourceList(String list) {
		mainView.setTransportResourceList(list);
	}
	
	public void setCurrentBuilding(String building) {
		mainView.setCurrentBuilding(building);
	}

	public void setOnClickBuildButton(EventHandler<ActionEvent> handler) {
		mainView.setOnClickBuildButton(handler);
	}
	
	public void setOnClickEndBuildTurn(EventHandler<ActionEvent> handler) {
		mainView.setOnClickEndBuildTurn(handler);
	}
	
	public void setCurrentResearch(String research) {
		mainView.setCurrentResearch(research);
	}
	
	public void setOnClickResearchButton(EventHandler<ActionEvent> handler) {
		mainView.setOnClickResearchButton(handler);
	}
	
	 public void moveCursorNW(){
	        mainView.moveCursorNW();
	    }
	    public void moveCursorNE(){
	        mainView.moveCursorNE();
	    }
	    public void moveCursorSW(){
	        mainView.moveCursorSW();
	    }
	    public void moveCursorSE(){
	        mainView.moveCursorSE();
	    }
	    public void moveCursorNorth(){
	        mainView.moveCursorNorth();
	    }
	    public void moveCursorSouth(){
	        mainView.moveCursorSouth();
	    }
	    
	    
	    public void swapToBuildingView() {
	    	mainView.swapToBuildingView();
	    }
	    
	    public void swapToResearchView() {
	    	mainView.swapToResearchView();
	    }
}
