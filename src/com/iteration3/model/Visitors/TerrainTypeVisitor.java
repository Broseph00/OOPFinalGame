package com.iteration3.model.Visitors;

import com.iteration3.model.Tiles.*;
import com.iteration3.utilities.GameLibrary;

public class TerrainTypeVisitor implements iTerrainVisitor {
    @Override
    public String getType(DesertTerrain terrain) { return GameLibrary.DESERT; }

    @Override
    public String getType(MountainTerrain terrain) {
        return GameLibrary.MOUNTAINS;
    }

    @Override
    public String getType(PastureTerrain terrain) {
        return GameLibrary.PASTURE;
    }

    @Override
    public String getType(RockTerrain terrain) {
        return GameLibrary.ROCK;
    }

    @Override
    public String getType(SeaTerrain terrain) {
        return GameLibrary.SEA;
    }

    @Override
    public String getType(WoodTerrain terrain) {
        return GameLibrary.WOODS;
    }
}
