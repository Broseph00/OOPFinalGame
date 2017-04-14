package com.iteration3.view;

import javafx.scene.control.TableView;

/**
 * Created by LesliesLaptop on 4/14/17.
 */
public class WonderView implements View {
    private TableView wonderTable;

    public WonderView(int wonderRows) {
        wonderTable = new TableView();
    }

    @Override
    // Use to update the wonder table
    public void update() {

    }

    public TableView getWonderTable() {
        return wonderTable;
    }
}
