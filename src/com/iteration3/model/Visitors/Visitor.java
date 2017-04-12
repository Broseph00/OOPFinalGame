package com.iteration3.model.Visitors;

import com.iteration3.model.Tiles.*;

public interface Visitor {
    public void visit(WoodTerrain terrain);
    public void visit(MountainTerrain terrain);
    public void visit(DesertTerrain terrain);
    public void visit(PastureTerrain terrain);
    public void visit(RockTerrain terrain);
    public void visit(SeaTerrain terrain);
}
