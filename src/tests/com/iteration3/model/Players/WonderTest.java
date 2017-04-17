//package com.iteration3.model.Players;

import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import com.iteration3.model.Players.Player;
import com.iteration3.model.Players.Wonder.Wonder;
import com.iteration3.model.Players.Wonder.WonderRow;
import com.iteration3.utilities.GameLibrary;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WonderTest {
    Map map;
    Wonder wonder;
    Player player1;
    Player player2;

    @Before
    public void setup(){
        map = new Map();
        wonder = new Wonder();
        player1 = new Player(map, 1, new RegionLocation(new Location(1,1, -2), 3), GameLibrary.PLAYER1_COLOR);
        player2 = new Player(map, 2, new RegionLocation(new Location(2, 3, -5), 4), GameLibrary.PLAYER2_COLOR);
    }

    @Test
    public void isFull() throws Exception {
        int brickCount = 0;
        while(wonder.addBrick(player1)){
            ++brickCount;
            System.out.println(brickCount);
        }
        assertEquals(83, brickCount);
        assertEquals(15, wonder.getRowCount());
    }

    @Test
    public void fullRowCount() throws Exception {
        int brickCount = 0;
        while(wonder.addNeutralBrick()){
            ++brickCount;
        }
        assertEquals(15, wonder.getRowCount());


        int fullRowCount = 0;
        for(WonderRow row : wonder.getRows()){
            fullRowCount += row.isFull() ? 1 : 0;
        }
        assertEquals(15, fullRowCount);
    }

    @Test
    public void addPlayerBrick() throws Exception {
        WonderRow wonderRow = new WonderRow(7);
        boolean brickAdded;
        brickAdded = wonderRow.addBrick(player1);

        assertTrue(brickAdded);
    }

    @Test
    public void addNeutralBrick() throws Exception {
        WonderRow wonderRow = new WonderRow(7);
        boolean brickAdded;
        brickAdded = wonderRow.addNeutralBrick();

        assertTrue(brickAdded);
    }

    @Test
    public void addBrickToWonderRow(){
        WonderRow wonderRow = new WonderRow(4);
        for(int i = 0; i < 4; ++i){
            wonderRow.addNeutralBrick();
        }

        assertTrue(wonderRow.isFull());
        assertEquals(4, wonderRow.getBrickCount());
    }

    @Test
    public void getWonderRowScore(){
        WonderRow wonderRow = new WonderRow(7);
        for(int i = 0; i < 1; ++i){
            wonderRow.addBrick(player1);
        }
        assertFalse(wonderRow.isFull());

        for(int i = 0; i < 5; ++i){
            wonderRow.addBrick(player2);
        }

        int player2Score = wonderRow.getScore(player2);
        assertEquals(8, player2Score);
    }

    @Test
    public void getWonderScore(){
        for(int i = 0; i < 2; ++i){
            wonder.addBrick(player2);
        }
        for(int i = 0; i < 3; ++i){
            wonder.addBrick(player1);
        }
        wonder.addNeutralBrick();
        for(int i = 0; i < 2; ++i){
            wonder.addBrick(player1);
        }

        int player1Score = wonder.getScore(player1);
        int player2Score = wonder.getScore(player2);

        assertEquals(15, player1Score);
        assertEquals(5, player2Score);
    }
}