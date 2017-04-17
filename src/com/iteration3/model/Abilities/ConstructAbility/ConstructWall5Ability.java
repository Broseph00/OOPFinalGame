package com.iteration3.model.Abilities.ConstructAbility;

import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/17/2017.
 */

/*--------------------------------------------------------------------------------------
|    ConstructWall1Ability Module: Created by test on 04/17/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class ConstructWall5Ability extends ConstructWallAbility {

    public ConstructWall5Ability(Transporter transporter, ExecutionManager executionManager){
        super(transporter, executionManager, GameLibrary.BUILD_WALL5_ABILITY, 5);
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
