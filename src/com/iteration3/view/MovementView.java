package com.iteration3.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class MovementView extends VBox {

	Label movementOption, currentTransportLabel;
	Button moveButton,endTurnButton;
	TextArea tileResourceList, transportResourceList;
	Text transporterTitle,  movementOptionTitle;
	
	
	public MovementView(double width, double height) {
		
		super(10);
		
		this.setWidth(width);
		this.setHeight(height);
		
		movementOption = new Label("None");
		currentTransportLabel = new Label("None");
		tileResourceList = new TextArea();
		transportResourceList = new TextArea(); 
		
		
		moveButton = new Button("Use Factory");
		endTurnButton = new Button("endTurn");
		
		transporterTitle = new Text("Transporter on Tile");
		movementOptionTitle = new Text("Choose a Direction");
		
		moveButton.setDisable(true);
		
		tileResourceList.setEditable(false);
		transportResourceList.setEditable(false);
		
		moveButton.setFocusTraversable(false);
		endTurnButton.setFocusTraversable(false);
		tileResourceList.setFocusTraversable(false);
		transportResourceList.setFocusTraversable(false);
		
		transportResourceList.setMaxWidth(width/2);
		tileResourceList.setMaxWidth(width/2);
		
		initializeView();
	}
	
	public MovementView() {
		
		super(10);
		
		movementOption = new Label("None");
		currentTransportLabel = new Label("None");
		tileResourceList = new TextArea();
		transportResourceList = new TextArea(); 
		
		transporterTitle = new Text("Transporter on Tile");
		movementOptionTitle = new Text("Choose a Direction");
		
		moveButton = new Button("Use Factory");
		endTurnButton = new Button("endTurn");
		
		moveButton.setDisable(true);
		
		tileResourceList.setEditable(false);
		transportResourceList.setEditable(false);
		
		moveButton.setFocusTraversable(false);
		endTurnButton.setFocusTraversable(false);
		tileResourceList.setFocusTraversable(false);
		transportResourceList.setFocusTraversable(false);
		
		initializeView();
	}
	
	private void initializeView() {
		
		Text mainTitle = new Text("Movement Phase");
		Text tileResourceTitle = new Text("Resources on Tile");
		Text transportResourceTitle = new Text("Resources on Transport");
		
		
		this.getChildren().add(mainTitle);
		this.getChildren().add(transporterTitle);
		this.getChildren().add(currentTransportLabel);
		this.getChildren().add(movementOptionTitle);
		this.getChildren().add(movementOption);
		
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
		
		this.getChildren().add(moveButton);
		this.getChildren().add(endTurnButton);
		
		this.setAlignment(Pos.TOP_CENTER);
		
		mainTitle.setFont(Font.font("Verdana", FontWeight.BOLD,20));
		transporterTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		transporterTitle.setFill(Color.BLUE);
		movementOptionTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		tileResourceTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		transportResourceTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		
		tileResourceList.setFont(Font.font(15));
		transportResourceList.setFont(Font.font(15));
		movementOption.setFont(Font.font(15));
		currentTransportLabel.setFont(Font.font(15));
		
		
	}
	
	public void highlightTransportOption() {
		transporterTitle.setFill(Color.BLUE);
		currentTransportLabel.setTextFill(Color.BLACK);
		
		movementOptionTitle.setFill(Color.BLACK);
		movementOption.setTextFill(Color.DARKGRAY);
	}
	
	public void highlightMovementOption() {
		movementOptionTitle.setFill(Color.BLUE);
		movementOption.setTextFill(Color.BLACK);
		
		transporterTitle.setFill(Color.BLACK);
		currentTransportLabel.setTextFill(Color.DARKGRAY);
	}
	
	public void setEnableMoveButton(Boolean isEnabled){
		moveButton.setDisable(!isEnabled);
	}
	
	public void setTileResourceList(String list) {
		tileResourceList.setText(list);
	}
	
	public void setTransportResourceList(String list) {
		transportResourceList.setText(list);
	}
	
	
	public void setCurrentTransporter(String currentTransporter) {
		currentTransportLabel.setText(currentTransporter);
	}
	
	public void setOnMoveButton(EventHandler<ActionEvent> handler) {
		moveButton.setOnAction(handler);
	}
	
	public void setOnClickEndMovementTurn(EventHandler<ActionEvent> handler) {
		endTurnButton.setOnAction(handler);
	}
}
