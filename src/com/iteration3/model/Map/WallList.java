package com.iteration3.model.Map;

import com.iteration3.model.Players.Player;

import java.util.ArrayList;

public class WallList {
    private ArrayList<Wall> walls;
    public WallList(){
        walls=new ArrayList<>();
    }

    public void add(Wall wall){
        walls.add(wall);
    }

    public void remove(int edge){
        for(int i = walls.size() - 1; i >= 0; i--) {
            if(walls.get(i).getEdge() == edge) {
                walls.remove(i);
                return;
            }
        }
    }

    public boolean isEmpty(){
        return walls.isEmpty();
    }

    public boolean contains(int edge){
        for(int i = walls.size() - 1; i >= 0; i--) {
            if(walls.get(i).getEdge() == edge) {
                return true;
            }
        }
        return false;
    }

    public boolean oppositeOwner(Player player, int edge){
        for(int i = walls.size() - 1; i >= 0; i--) {
            if(walls.get(i).getEdge() == edge) {
                return walls.get(i).oppositeOwner(player);
            }
        }
        return false;
    }

    public int wallStrength(int edge){
        for(int i = walls.size() - 1; i >= 0; i--) {
            if(walls.get(i).getEdge() == edge) {
                return walls.get(i).getStrength();
            }
        }
        return 0;
    }

}
