package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class ControlDispatch implements EventHandler<KeyEvent>{

    private ControlDispatchState currentState;

    public ControlDispatch(GameModel model, GameWindow window){

        //setCurrentState();
    }

    public void setCurrentState(ControlDispatchState state){
        currentState = state;
    }

    @Override
    public void handle(KeyEvent event) {

        currentState.handleInput(event);
    }
}
