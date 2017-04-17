package com.iteration3.controller.Modes;

import com.iteration3.model.GameModel;
import com.iteration3.model.Transporters.Transporter;

/**
 * Created by Clay on 4/16/2017.
 */
public class ResourceOnTransporterMode implements CycleMode {

    Transporter transporter;
    //TODO: getResourceList
    public ResourceOnTransporterMode(Transporter transporter){
        this.transporter = transporter;
    }
    @Override
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
