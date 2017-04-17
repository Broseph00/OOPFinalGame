package com.iteration3.controller.Controllers;

import com.iteration3.controller.Action;
import com.iteration3.controller.Observable;
import com.iteration3.controller.Observer;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class ProductionController implements Observable {

    GameModel model;
    GameWindow window;
    ArrayList<Observer> subscribers;
    boolean lastPlayer;
    HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> endTurn, useFactory;
    // Location current;
    //TODO: Iterator of transporters (or locations)

    public ProductionController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.keyMap = keyMap;
        lastPlayer = false;
        subscribers = new ArrayList<>();

        initializeKeyMap();
        createHandlers();
    }

    private void initializeKeyMap() {
        keyMap.put(KeyCode.RIGHT, new Action() {
            public void execute() {
                //iter.next();

            }
        });

        keyMap.put(KeyCode.LEFT, new Action() {
            public void execute() {
                //iter.prev();

            }
        });

    }

    private void createHandlers() {
        useFactory = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //model.nextPlayer();
                lastPlayer = !lastPlayer;
                if (lastPlayer);
                notifyAllObservers();
            }
        };

        endTurn = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                //model.nextPlayer();
                lastPlayer = !lastPlayer;
                if (lastPlayer);
                    notifyAllObservers();
            }
        };
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


