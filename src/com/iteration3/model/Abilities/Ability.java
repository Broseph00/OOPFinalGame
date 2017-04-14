package com.iteration3.model.Abilities;


import com.iteration3.model.Transporters.Transporter;

public abstract class Ability {
    private Transporter transporter;

    public Ability(Transporter transporter){
        this.transporter = transporter;

    }

    public void execute(){

    }
}
