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

    // helper functions
    public void addBoard() {
        this.resources.add(new Board());
    }

    public void removeBoard() {
        ArrayList<Board> boards = getBoards();
        if(boards.size() > 0) {
            this.resources.remove(boards.get(0));
        }
    }

    public void addClay() {
        this.resources.add(new Clay());
    }

    public void removeClay() {
        ArrayList<Clay> clay = getClay();
        if(clay.size() > 0) {
            this.resources.remove(clay.get(0));
        }
    }

    public void addCoin() {
        this.resources.add(new Coin());
    }

    public void removeCoin() {
        ArrayList<Coin> coins = getCoins();
        if(coins.size() > 0) {
            this.resources.remove(coins.get(0));
        }
    }

    public void addFuel() {
        this.resources.add(new Fuel());
    }

    public void removeFuel() {
        ArrayList<Fuel> fuel = getFuel();
        if(fuel.size() > 0) {
            this.resources.remove(fuel.get(0));
        }
    }

    public void addGold() {
        this.resources.add(new Gold());
    }

    public void removeGold() {
        ArrayList<Gold> gold = getGold();
        if(gold.size() > 0) {
            this.resources.remove(gold.get(0));
        }
    }

    public void addGoose() {
        this.resources.add(new Goose());
    }

    public void removeGoose() {
        ArrayList<Goose> geese = getGeese();
        if(geese.size() > 0) {
            this.resources.remove(geese.get(0));
        }
    }

    public void addIron() {
        this.resources.add(new Iron());
    }

    public void removeIron() {
        ArrayList<Iron> iron = getIron();
        if(iron.size() > 0) {
            this.resources.remove(iron.get(0));
        }
    }

    public void addPaper() {
        this.resources.add(new Paper());
    }

    public void removePaper() {
        ArrayList<Paper> paper = getPaper();
        if(paper.size() > 0) {
            this.resources.remove(paper.get(0));
        }
    }

    public void addStock() {
        this.resources.add(new Stock());
    }

    public void removeStock() {
        ArrayList<Stock> stock = getStock();
        if(stock.size() > 0) {
            this.resources.remove(stock.get(0));
        }
    }

    public void addStone() {
        this.resources.add(new Stone());
    }

    public void removeStone() {
        ArrayList<Stone> stones = getStones();
        if(stones.size() > 0) {
            this.resources.remove(stones.get(0));
        }
    }

    public void addTrunk() {
        this.resources.add(new Trunk());
    }

    public void removeTrunk() {
        ArrayList<Trunk> trunks = getTrunks();
        if(trunks.size() > 0) {
            this.resources.remove(trunks.get(0));
        }
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

    public void removeResource(Resource r) {
        this.resources.remove(r);
    }

    public void addResource(Resource r) {
        this.resources.add(r);
    }

}
