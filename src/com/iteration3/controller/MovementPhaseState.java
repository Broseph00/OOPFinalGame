package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

/**
 * Created by Clay on 4/13/2017.
 */
public class MovementPhaseState implements ControlDispatchState {
    private GameModel model;
    private GameWindow window;
    private ControlDispatch dispatch;
    private HashMap<KeyCode,Action> keyMap;
    private MovementController movementController;


    public MovementPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {
        keyMap = new HashMap<>();
        this.model = model;
        this.window = window;
        movementController = new MovementController(model, window, keyMap);
        this.dispatch = dispatch;
    }

    @Override
    public void handleInput(KeyEvent event) {

    }

    @Override
    public void nextState() {
        dispatch.changeState(new BuildingPhaseState(dispatch, model, window));
    }
}
