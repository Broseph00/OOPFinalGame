package com.iteration3.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class BuildingView extends VBox {

	Label currentTransportLabel, currentBuildingLabel;
	Button buildButton, endTurnButton;
	TextArea tileResourceList, transportResourceList;
	Text transporterTitle, buildingTitle; 
	
	public BuildingView(double width, double height) {
		
		super(10);
		
		this.setWidth(width);
		this.setHeight(height);
		
		currentTransportLabel = new Label("None");
		currentBuildingLabel = new Label("None");
		
		tileResourceList = new TextArea();
		transportResourceList = new TextArea(); 
		
		
		buildButton = new Button("Create Building");
		endTurnButton = new Button("endTurn");
		
		transporterTitle = new Text("Transporters on Tile");
		buildingTitle = new Text("Select the Building");
		
		buildButton.setDisable(true);
		
		tileResourceList.setEditable(false);
		transportResourceList.setEditable(false);
		
		buildButton.setFocusTraversable(false);
		endTurnButton.setFocusTraversable(false);
		tileResourceList.setFocusTraversable(false);
		transportResourceList.setFocusTraversable(false);
		
		transportResourceList.setMaxWidth(width/2);
		tileResourceList.setMaxWidth(width/2);
		
		initializeView();
	}
	
	public BuildingView() {
		
		super(10);
		
		currentTransportLabel = new Label("None");
		currentBuildingLabel = new Label("None");
		
		tileResourceList = new TextArea();
		transportResourceList = new TextArea(); 
		
		
		buildButton = new Button("Use Factory");
		endTurnButton = new Button("endTurn");
		
		transporterTitle = new Text("Transporters on Tile");
		buildingTitle = new Text("Select the Building");
		
		buildButton.setDisable(true);
		
		tileResourceList.setEditable(false);
		transportResourceList.setEditable(false);
		
		buildButton.setFocusTraversable(false);
		endTurnButton.setFocusTraversable(false);
		tileResourceList.setFocusTraversable(false);
		transportResourceList.setFocusTraversable(false);
				
		initializeView();
	}
	
	private void initializeView() {
		
		Text mainTitle = new Text("Building Phase");
		Text tileResourceTitle = new Text("Resources on Tile");
		Text transportResourceTitle = new Text("Resources on Transport");
		
		
		this.getChildren().add(mainTitle);
		this.getChildren().add(transporterTitle);
		this.getChildren().add(currentTransportLabel);
		this.getChildren().add(buildingTitle);
		this.getChildren().add(currentBuildingLabel);
		
		VBox resourceTileLayout = new VBox(10);
		resourceTileLayout.getChildren().add(tileResourceTitle);
		resourceTileLayout.getChildren().add(tileResourceList);
		resourceTileLayout.setAlignment(Pos.CENTER);
		
		
		VBox resourceTransportLayout = new VBox(10);
		resourceTransportLayout.getChildren().add(transportResourceTitle);
		resourceTransportLayout.getChildren().add(transportResourceList);
		resourceTransportLayout.setAlignment(Pos.CENTER);
		
		HBox resourcesLayout = new HBox(10);
		resourcesLayout.getChildren().add(resourceTileLayout);
		resourcesLayout.getChildren().add(resourceTransportLayout);
		resourcesLayout.setAlignment(Pos.CENTER);
		
		this.getChildren().add(resourcesLayout);
		
		this.getChildren().add(buildButton);
		this.getChildren().add(endTurnButton);
		
		this.setAlignment(Pos.TOP_CENTER);
		
		mainTitle.setFont(Font.font("Verdana", FontWeight.BOLD,20));
		transporterTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
	
		tileResourceTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		transportResourceTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		buildingTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		
		tileResourceList.setFont(Font.font(15));
		transportResourceList.setFont(Font.font(15));

		currentTransportLabel.setFont(Font.font(15));
		currentBuildingLabel.setFont(Font.font(15));
	}
	
	public void highlightTransportOption() {
		transporterTitle.setFill(Color.BLUE);
		currentTransportLabel.setTextFill(Color.BLACK);
		
		buildingTitle.setFill(Color.BLACK);
		currentBuildingLabel.setTextFill(Color.DARKGREY);
	}
	
	public void highlightBuildingOption() {
		
		buildingTitle.setFill(Color.BLUE);
		currentBuildingLabel.setTextFill(Color.BLACK);
		
		transporterTitle.setFill(Color.BLACK);
		currentTransportLabel.setTextFill(Color.DARKGRAY);
	}
	
	public void setEnableBuildButton(Boolean isEnabled){
		buildButton.setDisable(!isEnabled);
	}
	
	public void setTileResourceList(String list) {
		tileResourceList.setText(list);
	}
	
	public void setTransportResourceList(String list) {
		transportResourceList.setText(list);
	}
	
	public void setCurrentBuilding(String building) {
		currentBuildingLabel.setText(building);
	}

	public void setCurrentTransporter(String currentTransporter) {
		currentTransportLabel.setText(currentTransporter);
	}
	
	public void setOnClickBuildButton(EventHandler<ActionEvent> handler) {
		buildButton.setOnAction(handler);
	}
	
	public void setOnClickEndBuildTurn(EventHandler<ActionEvent> handler) {
		endTurnButton.setOnAction(handler);
	}
}
