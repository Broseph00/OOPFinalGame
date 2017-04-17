package com.iteration3.model.Abilities.DockAbility;

import com.iteration3.model.Abilities.Ability;
import com.iteration3.model.Managers.ExecutionManager;
import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Transporters.Water.WaterTransporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/16/2017.
 */

/*--------------------------------------------------------------------------------------
|    UndockAbility Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class UndockAbility extends Ability {

    public UndockAbility(Transporter transporter, ExecutionManager executionManager){
        super(transporter, GameLibrary.UNDOCK, executionManager);
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
