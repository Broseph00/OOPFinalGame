package com.iteration3.model.Tiles;


import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iTerrainVisitable;
import com.iteration3.model.Visitors.iTerrainVisitor;

public class DesertTerrain extends Terrain implements iTerrainVisitable {
    @Override
    public String getTerrainType(iTerrainVisitor visitor) {
        return visitor.getType(this);
    }

    public void acceptVisitor(Visitor visitor) {
        // TODO Auto-generated method stub
        visitor.visit(this);
    }
}
