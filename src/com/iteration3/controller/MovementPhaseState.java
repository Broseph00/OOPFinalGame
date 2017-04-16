package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import com.iteration3.view.MainView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

/**
 * Created by Clay on 4/13/2017.
 */
public class MovementPhaseState implements ControlDispatchState, Observer {
    private GameModel model;
    private GameWindow window;
    private ControlDispatch dispatch;
    private HashMap<KeyCode,Action> keyMap;
    private MovementController movementController;


    public MovementPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {

        this.model = model;
        this.window = window;
        this.dispatch = dispatch;
        keyMap = new HashMap<>();
        movementController = new MovementController(model, window, keyMap);
        movementController.addObserver(this);

    }

    @Override
    public void handleInput(KeyEvent event) {
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }

    @Override
    public void nextState() {
        dispatch.changeState(new BuildingPhaseState(dispatch, model, window));
    }

    public void update() {
        nextState();
    }
}
