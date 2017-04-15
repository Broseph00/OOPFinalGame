package com.iteration3.model.Managers;

import com.iteration3.model.Abilities.MoveAbility;
import com.iteration3.model.Map.Map;

public class MovementManager {
    private Map map;

    public MovementManager(Map map){
        this.map = map;
    }

    public boolean validateMoveAbility(MoveAbility moveAbility){
        return true;
        //TODO: do this
    }
}
