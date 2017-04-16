package com.iteration3.model.Players;

import java.util.ArrayList;

public class Wonder {
    private final int MAX_WONDER_ROWS = 15;
    private final int IRRIGATION_ROW = 10;
    private final int INCREASED_COST_ROW = 5;

    private ArrayList<WonderRow> rows;
    private int bricksPerRow;
    private int rowMultiplierCounter;
    private int currentTier;

    public Wonder() {
        rows = new ArrayList<WonderRow>();
        bricksPerRow = 4;
        rowMultiplierCounter = 1;
        newRow();
    }

    private void newRow() {
        if(isFull()) {
            return;
        } else {
            incrementRowMultiplierCounter();
            WonderRow wonderRow = new WonderRow(bricksPerRow);
            rows.add(wonderRow);
            checkIrrigation();
        }
    }

    private boolean isFull() {
        boolean reachedMaxRows = (rows.size() == MAX_WONDER_ROWS);
        if(reachedMaxRows){
            WonderRow currentRow = getCurrentRow();
            return currentRow.isFull();
        } else {
            return false;
        }
    }

    private void checkIrrigation() {
        // TODO: make call to Map to update desert tiles
    }

    private WonderRow getCurrentRow() {
        int maxIndex = rows.size() - 1;
        return rows.get(maxIndex);
    }

    private void incrementRowMultiplierCounter() {
        ++rowMultiplierCounter;
        if (rowMultiplierCounter == bricksPerRow) {
            resetMultiplier();
        }
    }

    private void resetMultiplier() {
        ++bricksPerRow;
        ++currentTier;
        rowMultiplierCounter = 1;
    }

    public void addBricks(Player owner, int quantity) {
        if(isFull()){
            return;
        }

        int bricksAdded = 0;
        int alreadyPaid = 0;

        WonderRow currentRow = getCurrentRow();
        for(int i = 0; i < quantity; ++i){
            if(currentRow.isFull()){
                newRow();
                currentRow = getCurrentRow();
            }

            int brickCost = calculateTotalBrickCost(i) - alreadyPaid;
            boolean playerPaid = false;
            // TODO: decrement cost from owner
            if(playerPaid){
                alreadyPaid += brickCost;
                bricksAdded += currentRow.addBrick(owner) ? 1 : 0;
            }
        }
    }

    private int calculateTotalBrickCost(int quantity) {
        int brickCost = 0;
        for (int i = 1; i <= quantity; i++) {
            int currentTier = (rows.size() < INCREASED_COST_ROW) ? 1 : 2;
            brickCost += (i + currentTier);
        }
        return brickCost;
    }

    public void addNeutralBrick() {
        if(isFull()){
            return;
        }

        WonderRow currentRow = getCurrentRow();
        if(currentRow.isFull()){
            newRow();
            currentRow = getCurrentRow();
        }

        currentRow.addNeutralBrick();
    }

    public int getScore(Player owner){
        int ownerScore = 0;

        for(WonderRow row : rows){
            ownerScore += row.getScore(owner);
        }

        return ownerScore;
    }

    public ArrayList<WonderRow> getRows() {
        final ArrayList<WonderRow> finalRows = this.rows;
        return finalRows;
    }

    public int getMaxWonderSize() {
        return MAX_WONDER_ROWS;
    }
}
