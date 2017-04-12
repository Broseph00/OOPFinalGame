package com.iteration3.model.Tiles;

import com.iteration3.model.Visitors.Visitable;
import com.iteration3.model.Visitors.Visitor;
import com.iteration3.model.Visitors.iTerrainVisitor;

public abstract class Terrain implements Visitable{
    public abstract String getTerrainType(iTerrainVisitor visitor);

    @Override
    public void acceptVisitor(Visitor visitor) {
        System.out.println("Here");
    }
}
