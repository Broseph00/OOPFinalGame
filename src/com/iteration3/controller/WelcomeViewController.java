package com.iteration3.controller;

import com.iteration3.GameEngine;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import com.iteration3.view.WelcomeViewWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class WelcomeViewController implements Observable {
    private GameModel model;
    private GameWindow window;
    private WelcomeViewWindow welcomeViewWindow;
    private HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> startNewGame, loadGame, quitGame;
    private ArrayList<Observer> subscribers;

    public WelcomeViewController(GameModel model, GameWindow window, WelcomeViewWindow welcomeViewWindow, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.welcomeViewWindow = welcomeViewWindow;
        this.keyMap = keyMap;
        this.subscribers = new ArrayList<>();

        initializeKeyMap();
        createHandlers();
    }
    public void startNewGame() throws Exception {
        GameEngine gameEngine = new GameEngine((Stage) welcomeViewWindow.getScene().getWindow(), model, window);
    }

    private void initializeKeyMap() {
//        keyMap.put(KeyCode.RIGHT, new Action() {
//            public void execute() {
//                //iter.next();
//
//            }
//        });
//
//        keyMap.put(KeyCode.LEFT, new Action() {
//            public void execute() {
//                //iter.prev();
//
//            }
//        });

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

                notifyAllObservers();
            }
        };

        quitGame = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Stage stage = (Stage)welcomeViewWindow.getScene().getWindow();
                stage.close();
                //notifyAllObservers();
            }
        };
        welcomeViewWindow.setOnClickStartNewGameButton(startNewGame);
        welcomeViewWindow.setOnClickExitGameButton(quitGame);
    }

    public void addObserver(Observer obs) {
        subscribers.add(obs);
    }

    public void removeObserver(Observer obs) {
        subscribers.remove(obs);
    }

    public void notifyAllObservers() {
        for (Observer o: subscribers)
            o.update();
    }
}
