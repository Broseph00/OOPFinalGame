package com.iteration3.model.Players.Research;

import com.iteration3.model.Visitors.Visitable;
import com.iteration3.model.Visitors.iResearchVisitor;

public abstract class Research implements Visitable{
    String name;

    public abstract String getResearchType(iResearchVisitor visitor);

    public Research(String name){
        this.name = name;
    }
}
