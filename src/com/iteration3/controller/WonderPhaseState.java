package com.iteration3.controller;

import javafx.scene.input.KeyEvent;

/**
 * Created by Clay on 4/14/2017.
 */
public class WonderPhaseState implements ControlDispatchState {
    private ControlDispatch dispatch;
    private WonderController wonderController;


    public WonderPhaseState(ControlDispatch dispatch) {
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
