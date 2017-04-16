package com.iteration3.model.Tiles;

import com.iteration3.model.Visitors.TerrainTypeVisitor;

public class Tile {

    private Terrain terrain;

    public Tile(Terrain t) {
        this.terrain = t;
    }

    public Terrain getTerrain() {
        return terrain;
    }
    public String getTerrainType() {
        return terrain.getTerrainType();
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }


}
