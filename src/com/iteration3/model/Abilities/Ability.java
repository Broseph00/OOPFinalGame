package com.iteration3.model.Abilities;


import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitable;
import com.iteration3.model.Visitors.iAbilityVisitor;

public abstract class Ability implements Visitable {
    private Transporter transporter;
    private String name;
    private ExecutionManager executionManager;

    public Ability(Transporter transporter, String name, ExecutionManager executionManager){
        this.transporter = transporter;
        this.name = name;
        this.executionManager = executionManager;
    }

    public abstract String getAbilityType(iAbilityVisitor visitor);

    public Transporter getTransporter(){
        return  transporter;
    }
    
    public String getName() {
    	return name;
    }

    public void execute(){
        executionManager.execute(this);
    }

}
