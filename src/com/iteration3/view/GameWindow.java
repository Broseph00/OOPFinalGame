package com.iteration3.view;

import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * Created by LesliesLaptop on 4/11/17.
 */
public class GameWindow extends BorderPane {
    private MenuBar menuBar;
    private MenuItem importMapFileItem, exportMapFileItem;
    //private MapView mapView;
    //private StatusView statusView;


    public GameWindow(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        //initializeWindow();
    }

    public void update() {}
}
