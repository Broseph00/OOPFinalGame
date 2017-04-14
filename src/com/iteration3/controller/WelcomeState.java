package com.iteration3.controller;

import com.iteration3.model.GameModel;
import com.iteration3.view.GameWindow;
import javafx.scene.input.KeyEvent;

    /**
     * Created by Clay on 4/13/2017.
     */
    public class WelcomeState implements ControlDispatchState{
        private GameModel model;
        private GameWindow window;
        private ControlDispatch dispatch;
        private WelcomeViewController welcome;

        public WelcomeState(ControlDispatch dispatch, GameModel model, GameWindow window){
            this.model = model;
            this.window = window;
            welcome = new WelcomeViewController();
            this.dispatch = dispatch;

        }

        //TODO: mixed-instance cohesion here due to mouseclicks only - split hierachy?
        public void handleInput(KeyEvent event){

        }

        public void nextState(){
            dispatch.changeState(new ProductionPhaseState(dispatch, model, window));
        }
    }
