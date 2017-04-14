package com.iteration3.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ProductionView extends VBox {

	Label terrainType, riverType, rotateOption;
	Button submitButton, removeButton; 
	Text selectTerrain, selectRiver;
	
	public ProductionView(double width, double height) {
		
		super(10);
		
		this.setWidth(width);
		this.setHeight(height);
		
		terrainType = new Label("");
		riverType = new Label("");
		rotateOption = new Label("");
		
		submitButton = new Button("Create Tile");
		removeButton = new Button("Remove Tile");
		
		//submitButton.setFocusTraversable(false);
		//removeButton.setFocusTraversable(false);
		
		selectTerrain = new Text("Select the tile's terrain");
		selectRiver = new Text("Select the tile's river");
		
		initializeView();
	}
	
	public ProductionView() {
		
		super(10);
		
		terrainType = new Label();
		riverType = new Label();
		rotateOption = new Label();
		
		submitButton = new Button("Create Tile");
		removeButton = new Button("Remove Tile");
		
		selectTerrain = new Text("Select the tile's terrain");
	    selectRiver = new Text("Select the tile's river");
		
		initializeView();
	}
	
	private void initializeView() {
		
	}
}
