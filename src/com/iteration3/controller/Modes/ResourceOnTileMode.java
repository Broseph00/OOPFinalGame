package com.iteration3.controller.Modes;

import com.iteration3.model.Transporters.Transporter;

/**
 * Created by Clay on 4/16/2017.
 */
public class ResourceOnTileMode implements CycleMode {

    Transporter transporter;
    public ResourceOnTileMode(Transporter transporter){
        this.transporter = transporter;
    }
    public void execute() {
        //
    }

    public void next() {

    }

    public void prev() {

    }

    public String getCurrentActionName() {
        return null;
    }
}
