package com.iteration3.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * Created by LesliesLaptop on 4/11/17.
 */

// Renamed GameWindow to MainView
public class MainView extends BorderPane implements View {
    private MapView mapView;
    private ProductionView productionView; 
    private Pane currentView; 

    public MainView(double width, double height) {
        this.setWidth(width);
        this.setHeight(height); 
        initializeWindow();
    }

    private void initializeWindow() {
        this.mapView = new MapView((3.0/4)*this.getWidth(), this.getHeight());
        this.productionView = new ProductionView((1.0/4)*this.getWidth(),this.getHeight());
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
//    public StatusView getStatusView() {
//        return statusView;
//    }
}
