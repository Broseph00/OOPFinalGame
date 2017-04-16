package com.iteration3.model.Players.Research;

import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iResearchVisitor;
import com.iteration3.utilities.GameLibrary;

public class OilResearch extends Research {
    //enables a player to build oil-rigs

    public OilResearch(){
        super(GameLibrary.OIL_RESEARCH);
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
