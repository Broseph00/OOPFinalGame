package com.iteration3.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Created by LesliesLaptop on 4/11/17.
 */

// Renamed GameWindow to MainView
public class MainView extends BorderPane implements View {
    private MapView mapView;
    private VBox statusBox;
    private ProductionView productionView;
    private TileView tileView;
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
//    public StatusView getStatusView() {
//        return statusView;
//    }

}
