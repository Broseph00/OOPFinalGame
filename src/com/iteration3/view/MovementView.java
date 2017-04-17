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

	Label movementOption, currentTransportLabel, currentTileResource, currentTransportResource;
	Button moveButton,endTurnButton, pickUpResourceButton,dropResourceButton; 
	Text transporterTitle,  movementOptionTitle, tileResourceTitle, transportResourceTitle;
	
	
	public MovementView(double width, double height) {
		
		super(10);
		
		this.setWidth(width);
		this.setHeight(height);
		
		movementOption = new Label("None");
		currentTransportLabel = new Label("None");
		currentTileResource  = new Label("None");
		currentTransportResource = new Label("None");
 		
		moveButton = new Button("Move Transporter");
		endTurnButton = new Button("End Turn");
		pickUpResourceButton = new Button ("Pick Up Resource");
		dropResourceButton = new Button("Drop Resource");
		
		transporterTitle = new Text("Transporter on Tile");
		movementOptionTitle = new Text("Choose a Direction");
		tileResourceTitle = new Text("Tile's Resources");
		transportResourceTitle = new Text("Transporter's Resources");
		
		moveButton.setDisable(true);
		pickUpResourceButton.setDisable(true);
		dropResourceButton.setDisable(true);
		
		pickUpResourceButton.setFocusTraversable(false);
		dropResourceButton.setFocusTraversable(false);
		moveButton.setFocusTraversable(false);
		endTurnButton.setFocusTraversable(false);
		
		initializeView();
	}
	
	public MovementView() {
		
		super(10);
		

		movementOption = new Label("None");
		currentTransportLabel = new Label("None");
		currentTileResource  = new Label("None");
		currentTransportResource = new Label("None");
 		
		moveButton = new Button("Use Factory");
		endTurnButton = new Button("endTurn");
		pickUpResourceButton = new Button ("Pick Up Resource");
		dropResourceButton = new Button("Drop Button");
		
		transporterTitle = new Text("Transporter on Tile");
		movementOptionTitle = new Text("Choose a Direction");
		tileResourceTitle = new Text("Tile's Resources");
		transportResourceTitle = new Text("Transporter's Resources");
		
		moveButton.setDisable(true);
		pickUpResourceButton.setDisable(true);
		dropResourceButton.setDisable(true);
		
		pickUpResourceButton.setFocusTraversable(false);
		dropResourceButton.setFocusTraversable(false);
		moveButton.setFocusTraversable(false);
		endTurnButton.setFocusTraversable(false);
		
		initializeView();
	}
	
	private void initializeView() {
		
		Text mainTitle = new Text("Movement Phase");
		
		this.getChildren().add(mainTitle);
		
		this.getChildren().add(transporterTitle);
		this.getChildren().add(currentTransportLabel);
		
		this.getChildren().add(movementOptionTitle);
		this.getChildren().add(movementOption);
		this.getChildren().add(moveButton);
		
		this.getChildren().add(transportResourceTitle);
		this.getChildren().add(currentTransportResource);
		
		this.getChildren().add(tileResourceTitle);
		this.getChildren().add(currentTileResource);
		
		this.getChildren().add(pickUpResourceButton);
		this.getChildren().add(dropResourceButton);
		
		this.getChildren().add(endTurnButton);
		
		this.setAlignment(Pos.TOP_CENTER);
		
		mainTitle.setFont(Font.font("Verdana", FontWeight.BOLD,20));
		transporterTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		movementOptionTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		tileResourceTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		transportResourceTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		
		currentTileResource.setFont(Font.font(15));
		currentTransportResource.setFont(Font.font(15));
		movementOption.setFont(Font.font(15));
		currentTransportLabel.setFont(Font.font(15));
		
		
	}
	
	public void highlightTransportOption() {
		transporterTitle.setFill(Color.BLUE);
		currentTransportLabel.setTextFill(Color.BLACK);
		
		movementOptionTitle.setFill(Color.BLACK);
		movementOption.setTextFill(Color.DARKGRAY);
		
		tileResourceTitle.setFill(Color.BLACK);
		currentTileResource.setTextFill(Color.DARKGRAY);
		
		transportResourceTitle.setFill(Color.BLACK);
		currentTransportResource.setTextFill(Color.DARKGRAY);
	}
	
	public void highlightMovementOption() {
		movementOptionTitle.setFill(Color.BLUE);
		movementOption.setTextFill(Color.BLACK);
		
		transporterTitle.setFill(Color.BLACK);
		currentTransportLabel.setTextFill(Color.DARKGRAY);
		
		tileResourceTitle.setFill(Color.BLACK);
		currentTileResource.setTextFill(Color.DARKGRAY);
		
		transportResourceTitle.setFill(Color.BLACK);
		currentTransportResource.setTextFill(Color.DARKGRAY);
	}
	
	public void highlightTileResourceOption() {
		
		tileResourceTitle.setFill(Color.BLUE);
		currentTileResource.setTextFill(Color.BLACK);
		
		movementOptionTitle.setFill(Color.BLACK);
		movementOption.setTextFill(Color.DARKGRAY);
		
		transporterTitle.setFill(Color.BLACK);
		currentTransportLabel.setTextFill(Color.DARKGRAY);
		
		transportResourceTitle.setFill(Color.BLACK);
		currentTransportResource.setTextFill(Color.DARKGRAY);
	}
	
	public void highlightTransportResourceOption() {
		
		transportResourceTitle.setFill(Color.BLUE);
		currentTransportResource.setTextFill(Color.BLACK);
		
		tileResourceTitle.setFill(Color.BLACK);
		currentTileResource.setTextFill(Color.DARKGRAY);
		
		movementOptionTitle.setFill(Color.BLACK);
		movementOption.setTextFill(Color.DARKGRAY);
		
		transporterTitle.setFill(Color.BLACK);
		currentTransportLabel.setTextFill(Color.DARKGRAY);
		
	}
	
	public void setEnableMoveButton(Boolean isEnabled){
		moveButton.setDisable(!isEnabled);
	}
	
	public void setEnablePickUpResourceButton(Boolean isEnabled){
		pickUpResourceButton.setDisable(!isEnabled);
	}
	
	public void setEnableDropResourceButton(Boolean isEnabled){
		dropResourceButton.setDisable(!isEnabled);
	}
	
	public void setCurrentTileResource(String resource) {
		currentTileResource.setText(resource);
	}
	
	public void setCurrentTransportResource(String resource) {
		currentTransportResource.setText(resource);
	}
	
	
	public void setCurrentTransporter(String currentTransporter) {
		currentTransportLabel.setText(currentTransporter);
	}
	
	public void setMovementOption(String movementOption) {
		this.movementOption.setText(movementOption);
	}
	
	public void setOnMoveButton(EventHandler<ActionEvent> handler) {
		moveButton.setOnAction(handler);
	}
	
	public void setOnClickEndMovementTurn(EventHandler<ActionEvent> handler) {
		endTurnButton.setOnAction(handler);
	}
	
	public void setOnClickPickUpResource(EventHandler<ActionEvent> handler) {
		pickUpResourceButton.setOnAction(handler);
	}
	
	public void setOnClickDropResource(EventHandler<ActionEvent> handler) {
		dropResourceButton.setOnAction(handler);
	}
}
