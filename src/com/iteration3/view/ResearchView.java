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

public class ResearchView extends VBox {

	Label currentResearchLabel;
	Button researchButton;
	
	public ResearchView(double width, double height) {
		
		super(10);
		
		this.setWidth(width);
		this.setHeight(height);
		
		currentResearchLabel = new Label("None");
		
		researchButton = new Button("Use Research");
		researchButton.setFocusTraversable(false);
		
		initializeView();
	}
	
	public ResearchView() {
		
		super(10);
		currentResearchLabel = new Label("None");
		
		researchButton = new Button("Use Research");
		researchButton.setFocusTraversable(false);
		
		initializeView();
	}
	
	private void initializeView() {
		
		Text mainTitle = new Text("Production Phase");
		Text researchTitle = new Text("Select Research");
		
		this.getChildren().add(mainTitle);
		this.getChildren().add(researchTitle);
		this.getChildren().add(currentResearchLabel);
		
		this.getChildren().add(researchButton);
		
		this.setAlignment(Pos.TOP_CENTER);
		
		mainTitle.setFont(Font.font("Verdana", FontWeight.BOLD,20));
		researchTitle.setFont(Font.font("Verdana", FontWeight.SEMI_BOLD, 15));
		researchTitle.setFill(Color.BLUE);
		
		currentResearchLabel.setFont(Font.font(15));
		
	}
	
	public void setCurrentResearch(String research) {
		currentResearchLabel.setText(research);
	}
	
	public void setOnClickResearchButton(EventHandler<ActionEvent> handler) {
		researchButton.setOnAction(handler);
	}
	
}
