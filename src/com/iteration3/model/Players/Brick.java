package com.iteration3.model.Players;

public class Brick {
    private Player owner;

    public Brick(Player player){
        owner = player;
    }

    public int count(Player player){
        if(owner.equals(player)){
            return 1;
        } else {
            return 0;
        }
    }

    public String getColor(){
        return owner.colorString();
    }
}
