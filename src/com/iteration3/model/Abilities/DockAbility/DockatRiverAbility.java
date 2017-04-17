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
|    DockatRiver Module: Created by test on 04/16/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public abstract class DockatRiverAbility extends Ability {
    int region;

    public DockatRiverAbility(Transporter transporter, ExecutionManager executionManager, String name, int region){
        super(transporter, name, executionManager);
        this.region = region;
    }

    public int getRegion(){return region;}

    public void execute(){
        executionManager.execute(this);
    }

}
