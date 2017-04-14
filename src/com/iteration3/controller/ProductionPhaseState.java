package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.HashMap;

public class ProductionPhaseState implements ControlDispatchState {
    private GameModel model;
    private GameWindow window;
    private ControlDispatch dispatch;
    private ProductionController productionController;
    private HashMap<KeyCode,Action> keyMap;

    public ProductionPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {
        this.model = model;
        this.window = window;
        this.dispatch = dispatch;
        keyMap = new HashMap<>();
        productionController = new ProductionController(model, window, keyMap);
    }

    @Override
    public void handleInput(KeyEvent event) {
        if (keyMap.containsKey(event.getCode()))
            keyMap.get(event.getCode()).execute();
    }

    @Override
    public void nextState() {
        dispatch.changeState(new MovementPhaseState(dispatch, model, window));
    }
}
