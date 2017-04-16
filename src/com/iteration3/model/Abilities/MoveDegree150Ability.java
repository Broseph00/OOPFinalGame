package com.iteration3.model.Abilities;

import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    MoveDegree150Ability Module: Created by test on 04/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MoveDegree150Ability extends MoveAbility{

    public MoveDegree150Ability(Transporter transporter, ExecutionManager executionManager){
        super(transporter,3,4, GameLibrary.MOVE_ANGLE150_ABILITY, executionManager);
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
