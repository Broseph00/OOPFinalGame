package com.iteration3.model.Buildings.Primary;

import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Resource.Resource;
import com.iteration3.model.Tiles.*;
import com.iteration3.model.Visitors.TerrainTypeVisitor;

public abstract class PrimaryProducer extends Producer {
/*
    private Terrain myTerrain;
    private TerrainTypeVisitor terrainVisitor;
*/

    public PrimaryProducer(/*Terrain requiredTerrain*/){
        super(1);
/*
        myTerrain = requiredTerrain;
        terrainVisitor = new TerrainTypeVisitor();
*/
    }

    public boolean verifyLocation(Tile tile){
/*
        Terrain terrain = tile.getTerrain();
        return verifyTerrain(terrain);
*/
        // Location verification to be done in a manager class
        return false;
    }

    private boolean verifyTerrain(Terrain terrain){
/*
        String myTerrainType = myTerrain.getTerrainType(terrainVisitor);
        String otherTerrainType = terrain.getTerrainType(terrainVisitor);
        // TODO: inquire about terrain equals method

        return myTerrainType.matches(otherTerrainType);
*/
        // Location verification to be done in a manager class
        return false;
    }

    public abstract Resource produce();
}
