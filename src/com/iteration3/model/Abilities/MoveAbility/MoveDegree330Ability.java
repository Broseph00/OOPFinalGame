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
|    MoveDegree330Ability Module: Created by test on 04/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MoveDegree330Ability extends MoveAbility {

    public MoveDegree330Ability(Transporter transporter, ExecutionManager executionManager){
        super(transporter, 6,1, GameLibrary.MOVE_ANGLE330_ABILITY, executionManager);
    }

    @Override
    public void acceptVisitor(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getAbilityType(iAbilityVisitor visitor) {
        return visitor.getType(this);
    }
    public void execute(){
        executionManager.execute(this);
    }

}
