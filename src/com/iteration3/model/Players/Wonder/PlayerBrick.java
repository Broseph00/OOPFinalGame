package com.iteration3.model.Players.Wonder;

import com.iteration3.model.Players.Player;

public class PlayerBrick implements Brick {
    private Player owner;

    public PlayerBrick(Player player){
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
        // return owner.colorString();
        // TODO: owner needs a color string or player ID
        return null;
    }

    public Player getOwner() {
        return owner;
    }
}
