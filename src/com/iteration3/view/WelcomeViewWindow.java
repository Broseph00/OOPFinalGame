package com.iteration3.view;

import com.iteration3.controller.WelcomeViewController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by LesliesLaptop on 4/12/17.
 */
public class WelcomeViewWindow extends BorderPane {
    private WelcomeViewController welcomeViewController;

    private Button startNewGameButton;

    public WelcomeViewWindow(double width, double height) {
        this.welcomeViewController = new WelcomeViewController();

        this.setWidth(width);
        this.setHeight(height);
        this.startNewGameButton = new Button("Start New Game");
        this.startNewGameButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    startNewGameHandler();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        this.setBottom(this.startNewGameButton);
    }

    public WelcomeViewController getController() {
        return welcomeViewController;
    }

    public void startNewGameHandler() throws Exception {
        getController().startNewGame(this);
    }
}
