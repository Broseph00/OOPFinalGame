package com.iteration3.model.Abilities.MoveAbility;

import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    MoveDegree240Ability Module: Created by test on 04/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MoveDegree240Ability extends MoveAbility {

    public MoveDegree240Ability(Transporter transporter, ExecutionManager executionManager){
        super(transporter,5,5, GameLibrary.MOVE_ANGLE240_ABILITY, executionManager);
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
