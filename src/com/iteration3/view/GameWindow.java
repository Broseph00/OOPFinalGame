package com.iteration3.view;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * Created by LesliesLaptop on 4/11/17.
 */
public class GameWindow extends BorderPane implements View {
    private MenuBar menuBar;
    private MapView mapView;
    private StatusView statusView;


    public GameWindow(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        initializeWindow();
    }

    private void initializeWindow() {
        this.mapView = new MapView((3.0/4)*this.getWidth(), this.getHeight());
        this.statusView = new StatusView((1.0/4)*this.getWidth(),this.getHeight());
        this.menuBar = new MenuBar();
        this.menuBar.prefWidthProperty().bind(this.widthProperty());

        Menu fileMenu = new Menu("File");
//        MenuItem newMap = new MenuItem("Create New Map");
//        importMapFileItem = new MenuItem("Import Map File...");
//        exportMapFileItem = new MenuItem("Export Map File...");
//        fileMenu.getItems().add(newMap);
//        fileMenu.getItems().add(importMapFileItem);
//        fileMenu.getItems().add(exportMapFileItem);
        this.menuBar.getMenus().add(fileMenu);

        //TODO: Add Status View to the addAll() call below
        this.setTop(menuBar);
        this.setRight(mapView);
        this.setLeft(statusView);

    }

    public void update() {
        mapView.update();
    }
}
