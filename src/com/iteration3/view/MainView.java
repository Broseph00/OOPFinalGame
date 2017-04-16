package com.iteration3.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * Created by LesliesLaptop on 4/11/17.
 */

//Renamed GameWindow to MainView
public class MainView extends BorderPane implements View {
    private MapView mapView;
    private StatusView statusView;


    public MainView(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        initializeWindow();
    }

    private void initializeWindow() {
        this.mapView = new MapView((3.0/4)*this.getWidth(), this.getHeight());
        this.statusView = new StatusView((1.0/4)*this.getWidth(),this.getHeight());

        this.setRight(mapView);
        this.setLeft(statusView);

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
}
