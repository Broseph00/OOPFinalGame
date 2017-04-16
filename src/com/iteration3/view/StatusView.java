package com.iteration3.view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class StatusView extends VBox {
	private ProductionView productionView;
	
	public StatusView(double width, double height) {
		this.productionView = new ProductionView();
		initializeView();
		swapToProductionView();
	}
	
	public StatusView() {
		
		//initializeView();
	}
	public void initializeView() {
		this.getChildren().add(getProductionView());
	}

	public void swapToProductionView() {
		getProductionView().setVisible(false);
	}

	public ProductionView getProductionView() {
		return productionView;
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

