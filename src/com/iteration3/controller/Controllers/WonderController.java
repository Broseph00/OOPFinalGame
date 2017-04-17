package com.iteration3.controller.Controllers;

import com.iteration3.controller.Action;
import com.iteration3.controller.Observer;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Clay on 4/14/2017.
 */
public class WonderController{

    private GameModel model;
    private GameWindow window;
    ArrayList<Observer> subscribers;
    boolean lastPlayer;
    HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> endTurn;
    int numBricks;

    public WonderController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.keyMap = keyMap;
        subscribers = new ArrayList<>();
        lastPlayer = false;
        numBricks = 0;

        initializeKeyMap();
        createHandlers();
    }

    private void initializeKeyMap() {
        keyMap.put(KeyCode.UP, new Action() {
            public void execute() {
                numBricks++;

            }
        });

        keyMap.put(KeyCode.DOWN, new Action() {
            public void execute() {
                numBricks--;

            }
        });

        keyMap.put(KeyCode.ENTER, new Action() {
            public void execute() {
                //model.buildBricks(numBricks);

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
