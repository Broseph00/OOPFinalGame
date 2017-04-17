package com.iteration3.model.Abilities.BuildAbility;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    BuildGoldMineAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class BuildGoldMineAbility extends Ability {

    public BuildGoldMineAbility(Transporter transporter, ExecutionManager executionManager){
        super(transporter, GameLibrary.BUILD_GOLD_MINE, executionManager);
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
