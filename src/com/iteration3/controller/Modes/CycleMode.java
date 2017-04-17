package com.iteration3.controller.Modes;

/**
 * Created by Clay on 4/16/2017.
 */
public interface CycleMode extends PhaseMode {

    public void execute();
    public void next();
    public void prev();
    public String getCurrentActionName();
}
