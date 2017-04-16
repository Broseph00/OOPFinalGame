package com.iteration3.view;


import com.iteration3.utilities.Assets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class StatusView extends VBox {
	private ProductionView productionView;
	private Pane currentPhasePane;
	private TileView tileView;
	private Assets images;
	
	public StatusView(double width, double height) {
		this.productionView = new ProductionView();
		this.tileView = new TileView();
		this.currentPhasePane = productionView;
		this.images = new Assets();
		initializeView();
		//swapToProductionView();
	}

	public void initializeView() {
		this.getChildren().add(productionView);
	}

	public void swapToProductionView() {
		getCurrentPhasePane().setVisible(false);
		productionView.setVisible(true);
		setCurrentPhasePane(productionView);
	}

	public void setCurrentPhasePane(Pane currentPhasePane) {
		this.currentPhasePane = currentPhasePane;
	}

	public Pane getCurrentPhasePane() {
		return currentPhasePane;
	}

	public void drawPreviewImage(String imageURL) {
		Image image = images.getImage(imageURL);
		//TODO: Add tile view stuff here
	}

	public TileView getTileView() {
		return tileView;
	}

	//	public void setOnClickSubmit(EventHandler<ActionEvent> handler) {
//		submitButton.setOnAction(handler);
//
//	}
//
//	public void setOnClickRemove(EventHandler<ActionEvent> handler) {
//		removeButton.setOnAction(handler);
//	}
//
//	public void addKeyHandler(EventHandler <KeyEvent> handler) {
//		this.setOnKeyPressed(handler);
//	}
//
//	public void invalidateSubmit() {
//		submitButton.setDisable(true);
//	}
//
//	public void validateSumbit() {
//		submitButton.setDisable(false);
//	}
}

