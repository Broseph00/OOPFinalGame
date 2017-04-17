package com.iteration3.view;

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

    private Pane currentView; 

    public MainView(double width, double height) {
        this.setWidth(width);
        this.setHeight(height); 
        initializeWindow();
    }

    private void initializeWindow() {
        this.mapView = new MapView((3.0/4)*this.getWidth(), this.getHeight());
        this.statusBox = new VBox();
        this.productionView = new ProductionView((1.0/4)*this.getWidth(),this.getHeight());
        this.tileView = new TileView();
        this.currentView = productionView;
        this.statusBox.getChildren().addAll(productionView, tileView);
        this.movementView = new MovementView((1.0/4)*this.getWidth(),this.getHeight());
        
        this.setRight(mapView);
        this.setLeft(statusBox);
    }
    
    public void swapToProductionView() {
        statusBox.getChildren().clear();
        statusBox.getChildren().addAll(productionView, tileView);
    	currentView = productionView;
    }

    public void drawTile(String imageURL, int x, int y) {
        getMapView().drawTile(imageURL, x, y);
    }
    public void drawRiver(String imageURL, int x, int y) {
        getMapView().drawRiver(imageURL, x, y);
    }
    public void drawPreviewImage(String imageURL) {
        //getStatusView().drawPreviewImage(imageURL);
    }

    public void update() {
        getMapView().update();
    }
    public MapView getMapView() {
        return mapView;
    }

    public void setEnableMoveButton(Boolean isEnabled){
		movementView.setEnableMoveButton(isEnabled);
	}
	
	public void setTileResourceList(String list) {
		movementView.setTileResourceList(list);
		productionView.setTileResourceList(list);
	}
	
	public void setTransportResourceList(String list) {
		movementView.setTransportResourceList(list);
		productionView.setTransportResourceList(list);;
	}
	
	
	public void setCurrentTransporter(String currentTransporter) {
		movementView.setCurrentTransporter(currentTransporter);
		productionView.setCurrentTransporter(currentTransporter);
	}
	
	public void setOnMoveButton(EventHandler<ActionEvent> handler) {
		movementView.setOnMoveButton(handler);
		
	}
	
	public void setOnClickEndMovementTurn(EventHandler<ActionEvent> handler) {
		movementView.setOnClickEndMovementTurn(handler);
	}
	
	public void setEnableFactoryButton(Boolean isEnabled){
		productionView.setDisable(!isEnabled);
	}
	
	public void setOnClickFactoryButton(EventHandler<ActionEvent> handler) {
		productionView.setOnClickFactoryButton(handler);
	}
	
	public void setOnClickEndProductionTurn(EventHandler<ActionEvent> handler) {
		productionView.setOnClickEndProductionTurn(handler);
	}
	
	public void highlightTransportOption() {
		movementView.highlightTransportOption();
	}
	
	public void highlightMovementOption() {
		movementView.highlightMovementOption();
	}

}
