package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class ControlDispatch implements EventHandler<KeyEvent>{

    GameModel model;
    GameWindow window;
    private ControlDispatchState currentState;


    public ControlDispatch(GameModel model, GameWindow window){

        this.model = model;
        this.window = window;
        currentState = new WelcomeState(this);
    }

    public void setCurrentState(ControlDispatchState state){
        currentState = state;
    }

    @Override
    public void handle(KeyEvent event) {

        currentState.handleInput(event);
    }

    public void changeState(ControlDispatchState newState){
        currentState = newState;
    }
}
