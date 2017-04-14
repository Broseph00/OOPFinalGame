package com.iteration3.controller;

import javafx.scene.input.KeyEvent;

    /**
     * Created by Clay on 4/13/2017.
     */
    public class WelcomeState implements ControlDispatchState{

        private ControlDispatch dispatch;
        private WelcomeViewController welcome;

        public WelcomeState(ControlDispatch dispatch){
            welcome = new WelcomeViewController();
            this.dispatch = dispatch;

        }

        public void handleInput(KeyEvent event){

        }

        public void nextState(){
            dispatch.changeState(new ProductionPhaseState(dispatch));
        }
    }
