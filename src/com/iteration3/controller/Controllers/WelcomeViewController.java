package com.iteration3.controller.Controllers;

import com.iteration3.GameEngine;

import com.iteration3.controller.Action;

import com.iteration3.model.GameModel;
import com.iteration3.model.Players.Player;
import com.iteration3.view.GameWindow;
import com.iteration3.utilities.Observable;
import com.iteration3.utilities.Observer;

import com.iteration3.view.WelcomeViewWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class WelcomeViewController implements Observable{
    private GameModel model;
    private GameWindow window;
    private WelcomeViewWindow welcomeViewWindow;
    private HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> startNewGame, loadGame, quitGame;
    private ArrayList<Observer> subscribers;
    Observer o;

    public WelcomeViewController(GameModel model, GameWindow window, WelcomeViewWindow welcomeViewWindow, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.welcomeViewWindow = welcomeViewWindow;
        this.keyMap = keyMap;
        this.subscribers = new ArrayList<>();

        //initializeKeyMap();
        createHandlers();
    }

    public void startNewGame() throws Exception {
        GameEngine gameEngine = new GameEngine((Stage) welcomeViewWindow.getScene().getWindow(), model, window);
    }

    public void quitGame() {
        Stage stage = (Stage)welcomeViewWindow.getScene().getWindow();
        stage.close();
    }

    private void createHandlers() {
        startNewGame = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    startNewGame();
                 } catch (Exception e1) {
                    e1.printStackTrace();
                 }
                notifyAllObservers();
            }
        };
        loadGame = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                notifyAllObservers();
            }
        };
        quitGame = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    quitGame();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                notifyAllObservers();
            }
        };
        welcomeViewWindow.setOnClickStartNewGameButton(startNewGame);
        welcomeViewWindow.setOnClickExitGameButton(quitGame);
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
