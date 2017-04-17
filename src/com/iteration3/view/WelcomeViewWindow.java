package com.iteration3.view;

import com.iteration3.controller.Controllers.WelcomeViewController;
import com.iteration3.utilities.Assets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by LesliesLaptop on 4/12/17.
 */
public class WelcomeViewWindow extends StackPane {

    private Button startNewGameButton;
    private Button loadGameButton;
    private Button exitGameButton;
    private Assets images;

    public WelcomeViewWindow(double width, double height) {
        this.images = new Assets();

        this.setWidth(width);
        this.setHeight(height);

        ImageView welcomeImage = new ImageView(getImages().getImage("welcomeImage"));
        this.getChildren().add(welcomeImage);

        initializeButtons();
    }

    public void initializeButtons() {
        VBox vbox = new VBox();
        vbox.setPrefWidth(150);
        vbox.setSpacing(20);
        this.startNewGameButton = new Button("Start New Game");
        this.loadGameButton = new Button("Load Game");
        this.exitGameButton = new Button("Exit Game");
        this.startNewGameButton.setMinWidth(vbox.getPrefWidth());
        this.loadGameButton.setMinWidth(vbox.getPrefWidth());
        this.exitGameButton.setMinWidth(vbox.getPrefWidth());
        vbox.getChildren().addAll(startNewGameButton, loadGameButton, exitGameButton);
        vbox.setAlignment(Pos.CENTER);
        this.getChildren().add(vbox);
    }

//    public void startNewGameHandler() throws Exception {
//        getController().startNewGame(this);
//    }
//    //TODO: Add load/save game functionality before implementing this method
//    public void loadGameHandler() throws Exception {
//
//    }
//    public void exitGameHandler() throws Exception {
//        Stage stage = (Stage)this.getScene().getWindow();
//        stage.close();
//    }

    public Assets getImages() {
        return images;
    }
    public void setOnClickStartNewGameButton (EventHandler<ActionEvent> handler) {
        startNewGameButton.setOnAction(handler);
    }

    public void setOnClickLoadGameButton(EventHandler<ActionEvent> handler) {
        loadGameButton.setOnAction(handler);
    }
    public void setOnClickExitGameButton(EventHandler<ActionEvent> handler) {
        exitGameButton.setOnAction(handler);
    }

}
