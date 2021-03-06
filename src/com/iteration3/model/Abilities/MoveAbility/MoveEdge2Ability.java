package com.iteration3.model.Abilities.MoveAbility;

import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/15/2017.
 */

/*--------------------------------------------------------------------------------------
|    MoveEdge2Ability Module: Created by test on 04/15/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MoveEdge2Ability extends MoveAbility {

    public MoveEdge2Ability(Transporter transporter, ExecutionManager executionManager){
        super(transporter, 7, 2, GameLibrary.MOVE_EDGE2_ABILITY, executionManager);
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
