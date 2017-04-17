package com.iteration3;

import com.iteration3.controller.ControlDispatch;
import com.iteration3.controller.WelcomeViewController;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import com.iteration3.view.WelcomeViewWindow;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by LesliesLaptop on 4/12/17.
 */
// NEW CLASS ADDED - Used to load up the initial welcome view screen
public class GameLoader extends Application {
    private WelcomeViewWindow welcomeViewWindow;
    private GameWindow gameWindow;
    private GameModel gameModel;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.welcomeViewWindow = new WelcomeViewWindow(1221, 726);
        this.gameWindow = new GameWindow(1221,726, 15);
        this.gameModel = new GameModel();
        ControlDispatch controller = new ControlDispatch(gameModel, gameWindow, welcomeViewWindow);

        //TODO: Make size equal to screen resolution
        Scene scene = new Scene(welcomeViewWindow, 1221, 726);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Roads & Boats");
        primaryStage.show();

    }
}
