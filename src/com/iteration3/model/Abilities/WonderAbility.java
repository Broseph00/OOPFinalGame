package com.iteration3.model.Abilities;

import com.iteration3.model.Players.Wonder;
import com.iteration3.model.Players.WonderManager;
import com.iteration3.model.Transporters.Transporter;

/**
 * Created by test on 04/17/2017.
 */

/*--------------------------------------------------------------------------------------
|    WonderAbility Module: Created by test on 04/17/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class WonderAbility {
    private Transporter transporter;
    private WonderManager wonderManager;

    public WonderAbility(Transporter transporter, WonderManager wonderManager){
        this.transporter = transporter;
        this.wonderManager = wonderManager;
    }

    public void execute(){

    }
}
