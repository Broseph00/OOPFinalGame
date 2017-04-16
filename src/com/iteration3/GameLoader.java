package com.iteration3;

import com.iteration3.controller.Controllers.WelcomeViewController;
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

    @Override
    public void start(Stage primaryStage) throws Exception {
        welcomeViewWindow = new WelcomeViewWindow(1221, 726);

        WelcomeViewController welcomeViewController = new WelcomeViewController();

        //TODO: Make size equal to screen resolution
        Scene scene = new Scene(welcomeViewWindow, 1221, 726);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Roads & Boats");
        primaryStage.show();

    }
}
