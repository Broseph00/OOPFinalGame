package com.iteration3.view;

import com.iteration3.model.Map.Location;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


/**
 * Created by LesliesLaptop on 4/11/17.
 */

// Renamed GameWindow to MainView
public class MainView extends BorderPane implements View {
    private MapView mapView;
    private VBox statusBox;
    private ProductionView productionView;
    private TileView tileView;
    private MovementView movementView; 
    private BuildingView buildingView;
    private ResearchView researchView;

    public MainView(double width, double height) {
        this.setWidth(width);
        this.setHeight(height); 
        initializeWindow();
    }

    private void initializeWindow() {
        this.mapView = new MapView((3.0/4)*this.getWidth(), this.getHeight());
        this.statusBox = new VBox();
        this.productionView = new ProductionView((1.0/4)*this.getWidth(),this.getHeight()*.5);
        this.tileView = new TileView();
      
        this.statusBox.getChildren().addAll(productionView, tileView);
        this.movementView = new MovementView((1.0/4)*this.getWidth(),this.getHeight());
        this.buildingView = new BuildingView((1.0/4)*this.getWidth(),this.getHeight());
        this.researchView = new ResearchView((1.0/4)*this.getWidth(),this.getHeight());
        
        this.setRight(mapView);
        this.setLeft(statusBox);
    }
    
    public void swapToProductionView() {
        statusBox.getChildren().clear();
        statusBox.getChildren().addAll(productionView, tileView);
    	
    }
    
    public void swapToMovementView() {
    	statusBox.getChildren().clear();
    	statusBox.getChildren().addAll(movementView,tileView);
    	
    }
    
    public void swapToBuildingView() {
    	statusBox.getChildren().clear();
    	statusBox.getChildren().addAll(buildingView,tileView);
    }
    
    public void swapToResearchView() {
    	statusBox.getChildren().clear();
    	statusBox.getChildren().addAll(researchView,tileView);
    }

    public void drawTile(String imageURL, int x, int y) {getMapView().drawTile(imageURL, x, y);}
    public void drawRiver(String imageURL, int x, int y) {getMapView().drawRiver(imageURL, x, y);}
    public void drawTransport(String imageURL, int x, int y, int region){getMapView().drawTransport(imageURL,x,y, region);}
    public void drawResource(String imageURL, int x, int y, int region){getMapView().drawResource(imageURL,x,y, region);}
	public void drawProducer(String imageURL, int x, int y, int region){getMapView().drawProducer(imageURL, x, y, region);}
    public void drawPreviewImage(String imageURL) {
        tileView.drawPreviewImage(imageURL);
    }
    public void clearPreviewImage() {
        tileView.clearPreviewImage();
    }
    public void drawBigResource(String url, int region) { tileView.drawResource(url, region);}

    public void update() {
        getMapView().update();
    }
    public MapView getMapView() {
        return mapView;
    }

    public void moveCursorNW(){
        mapView.moveCursorNW();
    }
    public void moveCursorNE(){
        mapView.moveCursorNE();
    }
    public void moveCursorSW(){
        mapView.moveCursorSW();
    }
    public void moveCursorSE(){
        mapView.moveCursorSE();
    }
    public void moveCursorNorth(){
        mapView.moveCursorNorth();
    }
    public void moveCursorSouth(){
        mapView.moveCursorSouth();
    }

    public Location getCursorLocation(){
        return mapView.getCursorLocation();
    }

    public void setEnableMoveButton(Boolean isEnabled){
		movementView.setEnableMoveButton(isEnabled);
	}
	
	
	public void setCurrentTransporter(String currentTransporter) {
		movementView.setCurrentTransporter(currentTransporter);
		productionView.setCurrentTransporter(currentTransporter);
		buildingView.setCurrentTransporter(currentTransporter);
	}
	
	public void setOnMoveButton(EventHandler<ActionEvent> handler) {
		movementView.setOnMoveButton(handler);
		
	}
	
	public void setOnClickEndMovementTurn(EventHandler<ActionEvent> handler) {
		movementView.setOnClickEndMovementTurn(handler);
	}
	
	public void setEnableFactoryButton(Boolean isEnabled){
		productionView.setDisable(isEnabled);
	}
	
	public void setOnClickFactoryButton(EventHandler<ActionEvent> handler) {
		productionView.setOnClickFactoryButton(handler);
	}
	
	public void setOnClickEndProductionTurn(EventHandler<ActionEvent> handler) {
		productionView.setOnClickEndProductionTurn(handler);
	}
	
	public void highlightTransportOption() {
		movementView.highlightTransportOption();
		buildingView.highlightTransportOption();
	}
	
	public void highlightMovementOption() {
		movementView.highlightMovementOption();
	}

	
	public void setEnablePickUpResourceButton(Boolean isEnabled){
		movementView.setEnablePickUpResourceButton(isEnabled);
	}
	
	public void setEnableDropResourceButton(Boolean isEnabled){
		movementView.setEnableDropResourceButton(isEnabled);
	}
	
	public void setCurrentTileResource(String resource) {
		movementView.setCurrentTileResource(resource);
	}
	
	public void setCurrentTransportResource(String resource) {
		movementView.setCurrentTransportResource(resource);
	}
	
	
	public void setOnClickPickUpResource(EventHandler<ActionEvent> handler) {
		movementView.setOnClickPickUpResource(handler);
	}
	
	public void setOnClickDropResource(EventHandler<ActionEvent> handler) {
		movementView.setOnClickDropResource(handler);
	}
	
	public void setMovementOption(String movementOption) {
		movementView.setMovementOption(movementOption);
	}
	
	
	public void highlightBuildingOption() {
		buildingView.highlightBuildingOption();
	}
	
	public void setEnableBuildButton(Boolean isEnabled){
		buildingView.setEnableBuildButton(isEnabled);
	}
	
	public void setTileResourceList(String list) {
		productionView.setTileResourceList(list);
		buildingView.setTileResourceList(list);
	}
	
	public void setTransportResourceList(String list) {
		productionView.setTransportResourceList(list);
		buildingView.setTransportResourceList(list);
	}
	
	public void setCurrentBuilding(String building) {
		buildingView.setCurrentBuilding(building);
	}

	public void setOnClickBuildButton(EventHandler<ActionEvent> handler) {
		buildingView.setOnClickBuildButton(handler);
	}
	
	public void setOnClickEndBuildTurn(EventHandler<ActionEvent> handler) {
		buildingView.setOnClickEndBuildTurn(handler);
	}
	
	public void setCurrentResearch(String research) {
		researchView.setCurrentResearch(research);
	}
	
	public void setOnClickResearchButton(EventHandler<ActionEvent> handler) {
		researchView.setOnClickResearchButton(handler);
	}
}
