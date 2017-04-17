package com.iteration3.model.Resource;

import com.iteration3.utilities.GameLibrary;

public class Stock extends Resource {
    @Override
    public String getType() {
        return GameLibrary.STOCK;
    }
}
