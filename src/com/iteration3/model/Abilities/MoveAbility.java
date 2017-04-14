package com.iteration3.model.Abilities;

import com.iteration3.model.Transporters.Transporter;

/**
 * Created by test on 04/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    MoveAbility Module: Created by test on 04/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MoveAbility extends Ability {
    int direction;

    public MoveAbility(Transporter transporter, int direction){
        super(transporter);
        this.direction = direction;

    }
}
