package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.*;

public class GoldMine extends Mine{
    @Override
    public void buildShaft() {
        for(int i = 0; i < 4; ++i){
            oreBag.add(new Gold());
        }
    }
}