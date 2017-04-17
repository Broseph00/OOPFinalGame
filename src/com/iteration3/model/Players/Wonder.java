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
        rows.add(new WonderRow(4));
    }

    private void newRow() {
        System.out.println("new row: " + rowMultiplierCounter);
        if (isFull() || (getRowCount() == MAX_WONDER_ROWS)) {
            return;
        } else {
            WonderRow wonderRow = new WonderRow(bricksPerRow);
            rows.add(wonderRow);
            incrementRowMultiplierCounter();
        }
    }

    public boolean isFull() {
        boolean reachedMaxRows = (rows.size() == MAX_WONDER_ROWS);
        if (reachedMaxRows) {
            WonderRow currentRow = getCurrentRow();
            return currentRow.isFull();
        } else {
            return false;
        }
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

    public boolean addBrick(Player owner) {
        if (isFull()) {
            return false;
        }

        WonderRow currentRow = getCurrentRow();
        if (currentRow.isFull()) {
            newRow();
            currentRow = getCurrentRow();
        }

        return currentRow.addBrick(owner);
    }

    public boolean addNeutralBrick() {
        if (isFull()) {
            return false;
        }

        WonderRow currentRow = getCurrentRow();
        if (currentRow.isFull()) {
            newRow();
            currentRow = getCurrentRow();
        }

        return currentRow.addNeutralBrick();
    }

    public int getScore(Player owner) {
        int ownerScore = 0;

        for (WonderRow row : rows) {
            ownerScore += row.getScore(owner);
        }

        return ownerScore;
    }

    public int getRowCount() {
        return rows.size();
    }

    public ArrayList<WonderRow> getRows() {
        final ArrayList<WonderRow> finalRows = this.rows;
        return finalRows;
    }

    public int getMaxWonderSize() {
        return MAX_WONDER_ROWS;
    }
}
