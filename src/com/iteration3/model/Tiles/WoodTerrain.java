package com.iteration3.model.Tiles;

import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iTerrainVisitable;
import com.iteration3.model.Visitors.iTerrainVisitor;
import com.iteration3.utilities.GameLibrary;

public class WoodTerrain extends Terrain {
    @Override
    public String getTerrainType() {
        return GameLibrary.WOODS;
    }

}
