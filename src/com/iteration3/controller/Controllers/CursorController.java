package com.iteration3.controller.Controllers;
/*--------------------------------------------------------------------------------------
|    CursorController: Created by Clay on 3/27/17.
|---------------------------------------------------------------------------------------
|   Controller to define functions for moving around the map to select a tile
|   Cursor keeps track of its location on the map
---------------------------------------------------------------------------------------*/
import com.iteration3.controller.Action;
import com.iteration3.controller.Observer;
import com.iteration3.model.GameModel;
//import com.iteration3.model.map.Location;
//import com.iteration3.model.map.Map;
import com.iteration3.view.MainView;
//import com.iteration3.view.Observable;
//import com.iteration3.view.Observer;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class CursorController implements Observable {

    private HashMap<KeyCode,Action> keyMap;
    private ArrayList<Observer> observers;
    private MainView window;

    public CursorController(GameModel model, MainView window, HashMap<KeyCode, Action> keymap) {
        this.keyMap = keymap;
        this.window = window;
        System.out.println("Cursor Controller Constructing");
        observers = new ArrayList<>();

        initializeKeyMap();
    }

    //load keymap with controls
    //could be adjusted to read from a file for custom controls

    private void initializeKeyMap(){
        keyMap.put(KeyCode.DIGIT0, new Action(){
            public void execute(){
                System.out.println("hi");
                window.moveCursorSW();
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD7, new Action(){
            public void execute(){
                window.moveCursorNW();
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD8, new Action(){
            public void execute(){
                window.moveCursorNorth();
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD9, new Action(){
            public void execute(){
                window.moveCursorNE();
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD3, new Action(){
            public void execute(){
                window.moveCursorSE();
                notifyAllObservers();

            }
        });

        keyMap.put(KeyCode.NUMPAD2, new Action(){
            public void execute(){
                window.moveCursorSouth();
                notifyAllObservers();

            }
        });
    }


    public void addObserver(Observer obs) {
        // TODO Auto-generated method stub
        observers.add(obs);
    }


    public void removeObserver(Observer obs) {
        // TODO Auto-generated method stub
        observers.remove(obs);
    }

//    @Override
//    public void notifyObserver(Observer obs) {
//        // TODO Auto-generated method stub
//        obs.update();
//    }


    public void notifyAllObservers() {
        // TODO Auto-generated method stub
        for(Observer obs: observers) {
            obs.update();
        }
    }

    @Override
    public void addListener(InvalidationListener listener) {

    }

    @Override
    public void removeListener(InvalidationListener listener) {

    }
}