package com.iteration3.model.Resource;

import java.util.ArrayList;

public class ResourceList {

    ArrayList<Resource> resources;

    public ResourceList() {
        this.resources = new ArrayList<>();
    }

    public ResourceList(ArrayList<Resource> resources) {
        this.resources = resources;
    }

    // getters
    public ArrayList<Board> getBoards() {
        ArrayList<Board> boards = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Board) {
                boards.add((Board) this.resources.get(i));
            }
        }
        return boards;
    }

    public ArrayList<Clay> getClay() {
        ArrayList<Clay> clay = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Clay) {
                clay.add((Clay) this.resources.get(i));
            }
        }
        return clay;
    }

    public ArrayList<Coin> getCoins() {
        ArrayList<Coin> coins = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Coin) {
                coins.add((Coin) this.resources.get(i));
            }
        }
        return coins;
    }

    public ArrayList<Fuel> getFuel() {
        ArrayList<Fuel> fuel = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Fuel) {
                fuel.add((Fuel) this.resources.get(i));
            }
        }
        return fuel;
    }

    public ArrayList<Gold> getGold() {
        ArrayList<Gold> gold = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Gold) {
                gold.add((Gold) this.resources.get(i));
            }
        }
        return gold;
    }


    public ArrayList<Goose> getGeese() {
        ArrayList<Goose> geese = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Goose) {
                geese.add((Goose) this.resources.get(i));
            }
        }
        return geese;
    }

    public ArrayList<Iron> getIron() {
        ArrayList<Iron> iron = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Iron) {
                iron.add((Iron) this.resources.get(i));
            }
        }
        return iron;
    }

    public ArrayList<Paper> getPaper() {
        ArrayList<Paper> paper = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Paper) {
                paper.add((Paper) this.resources.get(i));
            }
        }
        return paper;
    }

    public ArrayList<Stock> getStock() {
        ArrayList<Stock> stock = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Stock) {
                stock.add((Stock) this.resources.get(i));
            }
        }
        return stock;
    }

    public ArrayList<Stone> getStones() {
        ArrayList<Stone> stones = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Stone) {
                stones.add((Stone) this.resources.get(i));
            }
        }
        return stones;
    }

    public ArrayList<Trunk> getTrunks() {
        ArrayList<Trunk> trunks = new ArrayList<>();
        for(int i = 0; i < this.resources.size(); i++) {
            if(this.resources.get(i) instanceof Trunk) {
                trunks.add((Trunk) this.resources.get(i));
            }
        }
        return trunks;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }
}
