package com.iteration3.controller.Controllers;

import com.iteration3.GameEngine;
import com.iteration3.controller.Observable;
import com.iteration3.controller.Observer;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import com.iteration3.view.WelcomeViewWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class WelcomeViewController implements Observable{

    Observer o;
    private EventHandler<ActionEvent> startGame, loadGame, exitGame;

    public WelcomeViewController() {

    }

    public void startNewGame(WelcomeViewWindow welcomeViewWindow) throws Exception {
        GameEngine gameEngine = new GameEngine((Stage) welcomeViewWindow.getScene().getWindow());
    }

    private void createHandlers() {
        startGame = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                notifyAllObservers();
            }
        };

        loadGame = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //loadGame
            }
        };

        exitGame = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                System.exit(0);
            }
        };
    }


    @Override
    public void addObserver(Observer obs) {
        o = obs;
    }

    @Override
    public void removeObserver(Observer obs) {
        o = null;
    }

    @Override
    public void notifyAllObservers() {
        o.update();
    }
}
