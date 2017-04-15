package com.iteration3.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by LesliesLaptop on 4/14/17.
 */
public class WonderView extends VBox implements View {
    private TableView wonderTable;

    public WonderView(double width, double height, int numberOfRows) {
        initializeTable(numberOfRows);
    }

    @Override
    // Use to update the wonder table
    public void update() {

    }

    private void initializeTable(int numberOfRows) {
        this.wonderTable = new TableView();
        for (int i = 1; i <= numberOfRows; i++) {
            TableColumn wonderRow = new TableColumn(""+i);
            wonderTable.getColumns().add(wonderRow);
        }
        this.getChildren().add(wonderTable);
    }

    public TableView getWonderTable() {
        return wonderTable;
    }
}
