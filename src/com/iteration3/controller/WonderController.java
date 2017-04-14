package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.HashMap;

/**
 * Created by Clay on 4/14/2017.
 */
public class WonderController{

    private GameModel model;
    private GameWindow window;
    HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> endTurn;
    //TODO: Iterator of transporters

    public WonderController(GameModel model, GameWindow window, HashMap<KeyCode, Action> keyMap) {
        this.model = model;
        this.window = window;
        this.keyMap = keyMap;
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
        endTurn = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                //model.nextPlayer();
            }
        };
    }
}
