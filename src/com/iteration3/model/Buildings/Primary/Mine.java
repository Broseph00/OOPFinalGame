package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class Mine extends PrimaryProducer {
    protected ArrayList<Resource> oreBag;

    public Mine() {
        oreBag = new ArrayList<>();
        buildShaft();
    }

    @Override
    public Resource produce() {
        Resource ore = decrementCapacity() ? getOre() : null;
        return ore;
    }

    protected Resource getOre(){
        if(oreBag.isEmpty()){
            return null;
        }
        Random generator = new Random();
        int randomIdx = generator.nextInt(oreBag.size());

        return oreBag.get(randomIdx);
    }

    public abstract void buildShaft();

}
