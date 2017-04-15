package com.iteration3.model.Abilities;


import com.iteration3.model.Transporters.Transporter;

public abstract class Ability {
    private Transporter transporter;
    private String name;

    public Ability(Transporter transporter, String name){
        this.transporter = transporter;
        this.name = name;
    }

    public void execute(){

    }

    public Transporter getTransporter(){
        return  transporter;
    }
}
