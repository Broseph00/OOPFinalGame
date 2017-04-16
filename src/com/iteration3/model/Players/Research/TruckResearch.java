package com.iteration3.model.Players.Research;

import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iResearchVisitor;
import com.iteration3.utilities.GameLibrary;

public class TruckResearch extends Research {
    //enables a player to build truck factories

    public TruckResearch(){
        super(GameLibrary.TRUCK_RESEARCH);
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
