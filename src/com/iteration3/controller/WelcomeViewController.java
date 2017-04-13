package com.iteration3.controller;

import com.iteration3.GameEngine;
import com.iteration3.view.WelcomeViewWindow;
import javafx.stage.Stage;

/**
 * Created by LesliesLaptop on 4/12/17.
 */
public class WelcomeViewController {

    public WelcomeViewController() {

    }
    public void startNewGame(WelcomeViewWindow welcomeViewWindow) throws Exception {
        GameEngine gameEngine = new GameEngine((Stage) welcomeViewWindow.getScene().getWindow());
    }
}
