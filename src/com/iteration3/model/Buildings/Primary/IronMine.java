package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.*;
import com.iteration3.utilities.GameLibrary;

public class IronMine extends Mine{
    @Override
    public void buildShaft() {
        for(int i = 0; i < 4; ++i){
            oreBag.add(new Iron());
        }
    }

    @Override
    public String getType() {
        return GameLibrary.IRONMINE;
    }
}
