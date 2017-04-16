package com.iteration3.model.Abilities;

import com.iteration3.model.Transporters.Transporter;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iAbilityVisitor;
import com.iteration3.utilities.GameLibrary;

/**
 * Created by test on 04/14/2017.
 */

/*--------------------------------------------------------------------------------------
|    BuildRowboatFactoryAbility Module: Created by test on 04/14/2017.
|---------------------------------------------------------------------------------------
|   Description:
|
---------------------------------------------------------------------------------------*/

public class BuildRowboatFactoryAbility extends Ability {
    public BuildRowboatFactoryAbility(Transporter transporter){
        super(transporter, GameLibrary.BUILD_ROWBOAT_ABILITY);
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
