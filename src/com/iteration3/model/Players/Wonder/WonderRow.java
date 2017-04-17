package com.iteration3.model.Players.Wonder;

import com.iteration3.model.Players.Player;

import java.util.ArrayList;

public class WonderRow {
    private static int MAX_ROW_SCORE = 10;
    private int maxBrickCount;
    private ArrayList<Brick> bricks;

    public WonderRow(int maxSize) {
        maxBrickCount = maxSize;
        bricks = new ArrayList<>();
    }

    public boolean addBrick(Player owner) {
        if (owner == null) {
            throw new Error("owner argument cannot be null");
        }

        if (isFull()) {
            return false;
        } else {
            PlayerBrick newPlayerBrick = new PlayerBrick(owner);
            bricks.add(newPlayerBrick);
            return true;
        }
    }

    public boolean addNeutralBrick() {
        if (isFull()) {
            return false;
        } else {
            NeutralBrick newNeutralBrick = new NeutralBrick();
            bricks.add(newNeutralBrick);
            return true;
        }
    }

    public boolean isFull() {
        return (!(maxBrickCount > getBrickCount()));
    }

    public int getBrickCount() {
        int totalBricks = bricks.size();
        return totalBricks;
    }

    public int getScore(Player owner) {
        int ownerBricks = countOwnerBricks(owner);
        int totalPlayerBricks = countTotalPlayerBricks();

        int ownerScore = (MAX_ROW_SCORE * ownerBricks) / totalPlayerBricks;
        return ownerScore;
    }

    private int countTotalPlayerBricks(){
        int count = 0;

        for(Brick b : bricks){
            count += b instanceof PlayerBrick ? 1 : 0;
        }

        return count;
    }

    private int countOwnerBricks(Player owner) {
        int ownerBricks = 0;
        for (Brick b : bricks) {
            ownerBricks += b.count(owner);
        }
        return ownerBricks;
    }

    public ArrayList<String> getBricksList() {
        ArrayList<String> bricksList = new ArrayList<>();
        for(Brick b : bricks){
            bricksList.add(b.getColor());
        }
        return bricksList;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }
}
