package com.iteration3.model.Resource;

import com.iteration3.model.Livestock;
import com.iteration3.utilities.GameLibrary;

public class Goose extends Resource implements Livestock {
    @Override
    public String getType() {
        return GameLibrary.GOOSE;
    }
}
