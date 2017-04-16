package com.iteration3.model.Players.Research;

import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iResearchVisitor;
import com.iteration3.utilities.GameLibrary;

public class SpecializationResearch extends Research {
    //enables a player to fill mine bags with either gold or iron

    public SpecializationResearch(){
        super(GameLibrary.SPECIALIZATION_RESEARCH);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getResearchType(iResearchVisitor visitor) {
        return visitor.getType(this);
    }
}
