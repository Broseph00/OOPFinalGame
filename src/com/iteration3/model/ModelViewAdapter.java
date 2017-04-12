package com.iteration3.model;

import com.iteration3.view.GameWindow;

/**
 * Created by LesliesLaptop on 4/11/17.
 */
public class ModelViewAdapter {
    private GameModel gameModel;
    private GameWindow gameWindow;
    //private Location currentLocation;


    public ModelViewAdapter(GameModel gm, GameWindow gw){
        gameModel = gm;
        gameWindow = gw;
    }

    public void update() {}
}
