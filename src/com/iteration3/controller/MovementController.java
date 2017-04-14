package com.iteration3.controller;

/**
 * Created by Clay on 4/14/2017.
 */
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;

import java.util.HashMap;

public class MovementController{

    HashMap<KeyCode, Action> keyMap;
    private EventHandler<ActionEvent> nextPhase, nextPlayer;
    //TODO: Iterator of transporters

    public MovementController(HashMap<KeyCode, Action> keyMap) {
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
        nextPhase = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

                //model.nextPlayer();
            }
        };

        nextPlayer = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //state.nextState();
            }

        };
    }
}
