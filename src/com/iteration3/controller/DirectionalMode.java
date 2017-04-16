package com.iteration3.controller;

import javafx.scene.input.KeyCode;

/**
 * Created by Clay on 4/16/2017.
 */
public interface DirectionalMode extends PhaseMode {

    public void execute(KeyCode code);
}
