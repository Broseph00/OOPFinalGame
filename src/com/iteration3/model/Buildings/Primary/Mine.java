package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Resource.*;

import java.util.ArrayList;
import java.util.Random;

public class Mine extends PrimaryProducer {
    private ArrayList<Resource> oreBag;
//    Tile location;

    public Mine(/*Tile buildLocation*/) {
        oreBag = new ArrayList<>();
        buildDefaultShaft();
/*
        super(new MountainTerrain());
*/
    }

    @Override
    public Resource produce() {
        Resource ore = decrementCapacity() ? getOre() : null;
/*
        if (verifyLocation(location)) {
            // TODO: confirm produces only one ore when ore class updated
        }
*/
        return ore;
    }

    private Resource getOre(){
        if(oreBag.isEmpty()){
            return null;
        }
        Random generator = new Random();
        int randomIdx = generator.nextInt(oreBag.size());

        return oreBag.get(randomIdx);
    }

    private void buildDefaultShaft(){
        for(int i = 0; i < this.getBaseOreAmount(); ++i){
            oreBag.add(new Gold());
            oreBag.add(new Iron());
        }
    }

    private int getBaseOreAmount(){
        return 3;
    }

    public void buildIronShaft(){
        for(int i = 0; i < 4; ++i){
            oreBag.add(new Iron());
        }
    }

    public void buildGoldShaft(){
        for(int i = 0; i < 4; ++i){
            oreBag.add(new Gold());
        }
    }
}
