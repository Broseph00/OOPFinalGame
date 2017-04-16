package com.iteration3.model.Abilities;

import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    MoveEdge3Ability Module: Created by test on 04/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MoveEdge3Ability extends MoveAbility {

    public MoveEdge3Ability(Transporter transporter){
        super(transporter, 7, 3, GameLibrary.MOVE_EDGE3_ABILITY);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getAbilityType(iAbilityVisitor visitor) {
        return visitor.getType(this);
    }

}
