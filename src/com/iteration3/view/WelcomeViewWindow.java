package com.iteration3.view;

import com.iteration3.controller.Controllers.WelcomeViewController;
import com.iteration3.utilities.Assets;
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
    private WelcomeViewController welcomeViewController;

    private Button startNewGameButton;
    private Button loadGameButton;
    private Button exitGameButton;
    private Assets images;

    public WelcomeViewWindow(double width, double height) {
        this.welcomeViewController = new WelcomeViewController();
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
        this.startNewGameButton.setOnAction(event -> {
            try {
                startNewGameHandler();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.loadGameButton = new Button("Load Game");
        this.loadGameButton.setOnAction(event -> {
            try {
                loadGameHandler();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.exitGameButton = new Button("Exit Game");
        this.exitGameButton.setOnAction(event -> {
            try {
                exitGameHandler();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        this.startNewGameButton.setMinWidth(vbox.getPrefWidth());
        this.loadGameButton.setMinWidth(vbox.getPrefWidth());
        this.exitGameButton.setMinWidth(vbox.getPrefWidth());
        vbox.getChildren().addAll(startNewGameButton, loadGameButton, exitGameButton);
        vbox.setAlignment(Pos.CENTER);
        this.getChildren().add(vbox);
    }

    public WelcomeViewController getController() {
        return welcomeViewController;
    }

    public void startNewGameHandler() throws Exception {
        getController().startNewGame(this);
    }
    //TODO: Add load/save game functionality before implementing this method
    public void loadGameHandler() throws Exception {

    }
    public void exitGameHandler() throws Exception {
        Stage stage = (Stage)this.getScene().getWindow();
        stage.close();
    }

    public Assets getImages() {
        return images;
    }
}
