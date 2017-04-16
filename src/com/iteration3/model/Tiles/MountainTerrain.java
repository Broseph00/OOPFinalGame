package com.iteration3.model.Tiles;

import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iTerrainVisitable;
import com.iteration3.model.Visitors.iTerrainVisitor;

public class MountainTerrain extends Terrain {
    @Override
    public String getTerrainType() {
        return "mountains";
    }
}
