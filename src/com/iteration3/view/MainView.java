package com.iteration3.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * Created by LesliesLaptop on 4/11/17.
 */

//Renamed GameWindow to MainView
public class MainView extends BorderPane implements View {
    private MapView mapView;
    private ProductionView productionView; 
    private MovementView movementView; 
    private Pane currentView; 

    public MainView(double width, double height) {
        this.setWidth(width);
        this.setHeight(height); 
        initializeWindow();
    }

    private void initializeWindow() {
        this.mapView = new MapView((3.0/4)*this.getWidth(), this.getHeight());
        this.productionView = new ProductionView((1.0/4)*this.getWidth(),this.getHeight());
        this.movementView = new MovementView((1.0/4)*this.getWidth(),this.getHeight());
        currentView = productionView; 
        
        this.setRight(mapView);
        this.setLeft(productionView);
        
    }
    
    public void swapToProductionView() {
    	this.getChildren().remove(currentView);
    	this.setLeft(productionView);
    	currentView = productionView; 
    }

    public void drawTile(String imageURL, int x, int y) {
        mapView.drawTile(imageURL, x, y);
    }
    public void drawRiver(String imageURL, int x, int y) {
        mapView.drawRiver(imageURL, x, y);
    }

    public void update() {
        mapView.update();
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
