package com.iteration3.model.Players.Research;

import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iResearchVisitor;
import com.iteration3.utilities.GameLibrary;

public class EnlargementResearch extends Research{
    //Enables a player to fill mine bags with 5 gold and 5 iron

    public EnlargementResearch(){
        super(GameLibrary.ENLARGEMENT_RESEARCH);
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
