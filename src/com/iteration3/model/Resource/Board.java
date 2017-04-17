package com.iteration3.model.Resource;

import com.iteration3.utilities.GameLibrary;

public class Board extends Resource {
    @Override
    public String getType() {
        return GameLibrary.BOARD;
    }
}
