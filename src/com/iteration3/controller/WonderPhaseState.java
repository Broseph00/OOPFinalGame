package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyEvent;

/**
 * Created by Clay on 4/14/2017.
 */
public class WonderPhaseState implements ControlDispatchState {
    private ControlDispatch dispatch;
    private WonderController wonderController;


    public WonderPhaseState(ControlDispatch dispatch, GameModel model, GameWindow window) {
        wonderController = new WonderController();
        this.dispatch = dispatch;
    }

    @Override
    public void handleInput(KeyEvent event) {

    }

    @Override
    public void nextState() {
        dispatch.changeState(new ProductionPhaseState(dispatch));
    }
}
