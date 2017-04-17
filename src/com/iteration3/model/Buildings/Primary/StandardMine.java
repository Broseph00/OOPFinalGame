package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.*;

public class StandardMine extends Mine {
    @Override
    public void buildShaft() {
        for(int i = 0; i < 3; ++i){
            oreBag.add(new Iron());
            oreBag.add(new Gold());
        }
    }
}
