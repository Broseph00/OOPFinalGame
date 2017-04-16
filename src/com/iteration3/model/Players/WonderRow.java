package com.iteration3.model.Players;

import java.util.ArrayList;

public class WonderRow {
    private static int maxScore = 10;
    private int maxBrickCount;
    private ArrayList<Integer> neutralBricks;
    private ArrayList<Brick> playerBricks;

    public WonderRow(int maxSize) {
        maxBrickCount = maxSize;
        neutralBricks = new ArrayList<>();
        playerBricks = new ArrayList<>();
    }

    public boolean addBrick(Player owner) {
        if (owner == null) {
            throw new Error("owner argument cannot be null");
        }

        if (isFull()) {
            return false;
        } else {
            Brick newBrick = new Brick(owner);
            return true;
        }
    }

    public boolean addNeutralBrick() {
        if (isFull()) {
            return false;
        } else {
            int currentPosition = getBrickCount();
            neutralBricks.add(currentPosition);
            return true;
        }
    }

    public boolean isFull() {
        return (!(maxBrickCount > getBrickCount()));
    }

    public int getBrickCount() {
        int totalBricks = neutralBricks.size() + playerBricks.size();
        return totalBricks;
    }

    public int getScore(Player owner) {
        int ownerBricks = countOwnerBricks(owner);
        int totalPlayerBricks = playerBricks.size();

        int ownerScore = (maxScore * ownerBricks) / totalPlayerBricks;
        return ownerScore;
    }

    private int countOwnerBricks(Player owner) {
        int ownerBricks = 0;
        for (Brick b : playerBricks) {
            ownerBricks += b.count(owner);
        }
        return ownerBricks;
    }

    private ArrayList<String> getBricksList() {
        ArrayList<String> bricksList = new ArrayList<>();
        int neutralBricksAdded = 0;
        int playerBricksAdded = 0;

        for (int neutralBrickPosition : neutralBricks) {
            int totalBricksAdded = neutralBricksAdded + playerBricksAdded;

            while (totalBricksAdded != neutralBrickPosition) {
                Brick brick = playerBricks.get(totalBricksAdded);
                bricksList.add(brick.getColor());
                ++playerBricksAdded;
            }

            bricksList.add("White");
            ++neutralBricksAdded;
        }

        return bricksList;
    }
}
