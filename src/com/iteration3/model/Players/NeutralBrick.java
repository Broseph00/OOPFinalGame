package com.iteration3.model.Players;

public class NeutralBrick implements Brick{
    @Override
    public int count(Player player) {
        return 0;
    }

    @Override
    public String getColor() {
        return "White";
    }
}
