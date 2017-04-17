package com.iteration3.controller.Modes;

import com.iteration3.model.TransporterIterator;

/**
 * Created by Clay on 4/16/2017.
 */
public class TransporterMode implements CycleMode {

    TransporterIterator iterator;
    public TransporterMode(TransporterIterator iterator){
        this.iterator = iterator;
    }

    public void execute() {

    }

    @Override
    public void next() {

    }

    @Override
    public void prev() {

    }

    @Override
    public String getCurrentActionName() {
        return null;
    }
}
