package com.iteration3.controller;

import com.iteration3.controller.PhaseStates.ControlDispatchState;
import com.iteration3.controller.PhaseStates.WelcomeState;
import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;

import com.iteration3.view.WelcomeViewWindow;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class ControlDispatch implements EventHandler<KeyEvent>{

    GameModel model;
    GameWindow window;
    WelcomeViewWindow welcomeViewWindow;
    private ControlDispatchState currentState;


    public ControlDispatch(GameModel model, GameWindow window, WelcomeViewWindow welcomeViewWindow){
        this.model = model;
        this.window = window;
        this.welcomeViewWindow = welcomeViewWindow;
        currentState = new WelcomeState(this, model, window, welcomeViewWindow);
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

    public ControlDispatchState getCurrentState(){
        return currentState;
    }
}
