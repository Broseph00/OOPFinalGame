package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

/**
 * Created by Clay on 4/14/2017.
 */
public class WonderPhaseState implements ControlDispatchState, Observer {
    private GameModel model;
    private GameWindow window;
    private ControlDispatch dispatch;
    private WonderController wonderController;
    private HashMap<KeyCode,Action> keyMap;


    public WonderPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {
        this.model = model;
        this.window = window;
        this.dispatch = dispatch;
        keyMap = new HashMap<>();
        wonderController = new WonderController(model, window, keyMap);
        wonderController.addObserver(this);

    }

    @Override
    public void handleInput(KeyEvent event) {
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }

    @Override
    public void nextState() {
        dispatch.changeState(new ProductionPhaseState(dispatch, model, window));
    }

    public void update() {
        nextState();
    }
}
