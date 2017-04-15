package com.iteration3.model.Abilities;

import com.iteration3.model.Transporters.Transporter;

/**
 * Created by test on 04/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    MoveDegree30Ability Module: Created by test on 04/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class MoveDegree30Ability extends MoveAbility {

    public MoveDegree30Ability(Transporter transporter){
        super(transporter,1,2, "MOVE NORTHEAST");
    }
}
