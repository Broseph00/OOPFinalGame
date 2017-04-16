package com.iteration3.model.Abilities;


import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitable;
import com.iteration3.model.Visitors.iAbilityVisitor;

public abstract class Ability implements Visitable {
    private Transporter transporter;
    private String name;

    public Ability(Transporter transporter, String name){
        this.transporter = transporter;
        this.name = name;
    }

    public void execute(){

    }

    public abstract String getAbilityType(iAbilityVisitor visitor);

    public Transporter getTransporter(){
        return  transporter;
    }
}
