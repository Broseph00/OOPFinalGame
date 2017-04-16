package com.iteration3.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ProductionView extends VBox {

	Label currentTransportLabel;
	Button useFactoryButton, endTurnButton;
	TextArea tileResourceList, transportResourceList;
	
	
	public ProductionView(double width, double height) {
		
		super(10);
		
		this.setWidth(width);
		this.setHeight(height);
		
		currentTransportLabel = new Label("None");
		tileResourceList = new TextArea();
		transportResourceList = new TextArea(); 
		
		
		useFactoryButton = new Button("Use Factory");
		endTurnButton = new Button("endTurn");
		
		useFactoryButton.setVisible(false);
		useFactoryButton.setDisable(true);
		
		tileResourceList.setEditable(false);
		transportResourceList.setEditable(false);
		
		useFactoryButton.setFocusTraversable(false);
		endTurnButton.setFocusTraversable(false);
		tileResourceList.setFocusTraversable(false);
		transportResourceList.setFocusTraversable(false);
		
		transportResourceList.setMaxWidth(width/2);
		tileResourceList.setMaxWidth(width/2);
		
		initializeView();
	}
	
	public ProductionView() {
		
		super(10);
		
		currentTransportLabel = new Label("None");
		tileResourceList = new TextArea();
		transportResourceList = new TextArea(); 
		
		useFactoryButton = new Button("Use Factory");
		endTurnButton = new Button("End Turn");
		
		useFactoryButton.setVisible(false);
		useFactoryButton.setDisable(true);
		
		tileResourceList.setEditable(false);
		transportResourceList.setEditable(false);
		
		useFactoryButton.setFocusTraversable(false);
		endTurnButton.setFocusTraversable(false);
		tileResourceList.setFocusTraversable(false);
		transportResourceList.setFocusTraversable(false);
		
		initializeView();
	}
	
	private void initializeView() {
		
		Text mainTitle = new Text("Production Phase");
		Text tileResourceTitle = new Text("Resources on Tile");
		Text transportResourceTitle = new Text("Resources on Transport");
		Text transporterTitle = new Text("Transporters on Tile");
		
		this.getChildren().add(mainTitle);
		this.getChildren().add(transporterTitle);
		this.getChildren().add(currentTransportLabel);
		
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
		
		this.getChildren().add(useFactoryButton);
		this.getChildren().add(endTurnButton);
		
		this.setAlignment(Pos.TOP_CENTER);
		
		mainTitle.setFont(Font.font("Verdana", FontWeight.BOLD,20));
		transporterTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		transporterTitle.setFill(Color.BLUE);
		tileResourceTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		transportResourceTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		
		tileResourceList.setFont(Font.font(15));
		transportResourceList.setFont(Font.font(15));
		
		
	}
	
	public void setEnableFactoryButton(Boolean isEnabled){
		useFactoryButton.setDisable(!isEnabled);
	}
	
	public void setTileResourceList(String list) {
		tileResourceList.setText(list);
	}
	
	public void setTransportResourceList(String list) {
		transportResourceList.setText(list);
	}
	
	public void setFactoryButtonVisbile(Boolean isVisible) {
		useFactoryButton.setVisible(isVisible);
	}
	
	public void setCurrentTransporter(String currentTransporter) {
		currentTransportLabel.setText(currentTransporter);
	}
	
	public void setOnClickFactoryButton(EventHandler<ActionEvent> handler) {
		useFactoryButton.setOnAction(handler);
	}
	
	public void setOnClickEndTurn(EventHandler<ActionEvent> handler) {
		endTurnButton.setOnAction(handler);
	}
}
