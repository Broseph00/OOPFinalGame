package com.iteration3.controller;

import com.iteration3.controller.PhaseStates.ControlDispatchState;
import com.iteration3.controller.PhaseStates.ProductionPhaseState;
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
    //private ControlDispatchState savedState;


    public ControlDispatch(GameModel model, GameWindow window, WelcomeViewWindow welcomeViewWindow){
        this.model = model;
        this.window = window;
        this.welcomeViewWindow = welcomeViewWindow;
        currentState = new WelcomeState(this, model, window, welcomeViewWindow);
        window.addKeyHandler(this);

    }
/*
    public ControlDispatch(GameModel model, GameWindow window){
        this.model = model;
        this.window = window;
        currentState = new ProductionPhaseState(this, model, window);
        window.addKeyHandler(this);
    }
*/
    public void setCurrentState(ControlDispatchState state){
        currentState = state;
    }

    @Override
    public void handle(KeyEvent event) {
        System.out.println(currentState);
        System.out.println("Coming from keyevent");
        //currentState = savedState;

        currentState.handleInput(event);
    }

    public void changeState(ControlDispatchState newState){
        System.out.println(currentState);
        System.out.println("Change state to " + newState);
        currentState = newState;
        System.out.println(currentState);
        //savedState = newState;

    }

    public ControlDispatchState getCurrentState(){
        return currentState;
    }
}
