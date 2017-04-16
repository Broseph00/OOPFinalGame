package com.iteration3.controller;

/**
 * Created by Clay on 4/14/2017.
 */
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class MovementController implements Observable{

    private GameModel model;
    private GameWindow window;
    ArrayList<Observer> subscribers;
    boolean lastPlayer;
    HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> endTurn;
    //TODO - Iterator over transporters, valid tiles around them

    public MovementController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.keyMap = keyMap;
        subscribers = new ArrayList<>();
        lastPlayer = false;

        initializeKeyMap();
        createHandlers();
    }

    private void initializeKeyMap() {
        keyMap.put(KeyCode.RIGHT, new Action() {
            public void execute() {
                //transIter.next();

            }
        });

        keyMap.put(KeyCode.LEFT, new Action() {
            public void execute() {
                //transIter.prev();

            }
        });

        keyMap.put(KeyCode.NUMPAD6, new Action() {
            public void execute() {
                //locationIter.next();

            }
        });

        keyMap.put(KeyCode.NUMPAD4, new Action() {
            public void execute() {
                //locationIter.prev();

            }
        });

        keyMap.put(KeyCode.SPACE, new Action() {
            public void execute() {
                //pickUpResources();

            }
        });



    }

    private void createHandlers() {
        endTurn = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                //model.nextPlayer();
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
