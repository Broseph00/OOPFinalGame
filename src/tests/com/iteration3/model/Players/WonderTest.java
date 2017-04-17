package com.iteration3.model.Players;

import com.iteration3.model.Map.Location;
import com.iteration3.model.Map.Map;
import com.iteration3.model.Map.RegionLocation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Philip on 4/17/2017.
 */
public class WonderTest {
    Map map;
    Wonder wonder;
    Player player1;
    Player player2;

    @Before
    public void setup(){
        map = new Map();
        wonder = new Wonder();
        player1 = new Player(map, 1, new RegionLocation(new Location(1,1, -2), 3));
        player2 = new Player(map, 2, new RegionLocation(new Location(2, 3, -5), 4));
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
    }

    @Test
    public void addBrick() throws Exception {
    }

    @Test
    public void addNeutralBrick() throws Exception {
    }

    @Test
    public void getScore() throws Exception {
    }

    @Test
    public void getRowCount() throws Exception {
    }

    @Test
    public void addBrickToWonderRow(){
        WonderRow wonderRow = new WonderRow(4);
        for(int i = 0; i < 4; ++i){
            wonderRow.addNeutralBrick();
        }

        ArrayList<Brick> bricks = wonderRow.getBricks();

        assertTrue(wonderRow.isFull());
        assertEquals(4, bricks.size());
        assertEquals(4, wonderRow.getBrickCount());
    }

    @Test
    public void getWonderRowScore(){
        WonderRow wonderRow = new WonderRow(4);
        for(int i = 0; i < 1; ++i){
            wonderRow.addBrick(player1);
        }
        assertFalse(wonderRow.isFull());

        for(int i = 0; i < 3; ++i){
            wonderRow.addBrick(player2);
        }
        assertTrue(wonderRow.isFull());

        int player2Score = wonderRow.getScore(player2);
        assertEquals(7, player2Score);
    }
}