package com.iteration3.model.Players;

import java.util.ArrayList;

public class Wonder {
    private final int MAX_WONDER_ROWS = 15;
    private final int IRRIGATION_ROW = 10;

    private ArrayList<WonderRow> rows;
    private int bricksPerRow;
    private int rowMultiplierCounter;
    // TODO: need brick cost manager?

    public Wonder() {
        rows = new ArrayList<>();
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
        rowMultiplierCounter = 1;
    }

    public void addBrick(Player owner) {
        // TODO: need brick cost
        // TODO: decrement cost from owner
        if(isFull()){
            return;
        }

        WonderRow currentRow = getCurrentRow();
        if(currentRow.isFull()){
            newRow();
            currentRow = getCurrentRow();
        }

        currentRow.addBrick(owner);
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
