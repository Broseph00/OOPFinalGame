package com.iteration3.model.Map;

import java.util.ArrayList;

public class River {

    // 1 is North, 2 is NorthEast, 3 is SouthEast, 4 is South, 5 is SouthWest, 6 is NorthWest
    private ArrayList<Integer> riverEdges;
    private ArrayList<Integer> bridges;

    public River() {
        this.riverEdges = new ArrayList<Integer>();
        this.bridges = new ArrayList<Integer>();
    }

    public River(ArrayList<Integer> arrayList) {
        this.riverEdges = arrayList;
        this.bridges = new ArrayList<Integer>();
    }

    // Constructors for river types with various number of edges
    public River(int edge1) {
        this.riverEdges = new ArrayList<Integer>();
        this.bridges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
    }

    public River(int edge1, int edge2) {
        this.riverEdges = new ArrayList<Integer>();
        this.bridges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
        this.riverEdges.add(edge2);
    }

    public River(int edge1, int edge2, int edge3) {
        this.riverEdges = new ArrayList<Integer>();
        this.bridges = new ArrayList<Integer>();
        this.riverEdges.add(edge1);
        this.riverEdges.add(edge2);
        this.riverEdges.add(edge3);
    }

    // riveredge helper functions

    // add edge if that edge isn't already in the list and if size < 3
    public void addRiverEdge(int edge) {
        if(this.riverEdges.size() < 3 && !riverEdges.contains(Integer.valueOf(edge))) {
            this.riverEdges.add(edge);
        }
    }

    public void removeRiverEdge(int edge) {
        this.riverEdges.remove(Integer.valueOf(edge));
    }

    public ArrayList<Integer> getRiverEdges() {
        return riverEdges;
    }

    public void setRiverEdges(ArrayList<Integer> riverEdges) {
        this.riverEdges = riverEdges;
    }


    public boolean containsRiverEdge(int i){
        if(riverEdges.contains(i)){
            return true;
        }
        else{
            return false;
        }
    }

    public void printRiverEdgesandBridges() {
        System.out.println("Edges: " + this.riverEdges);
        System.out.println("Bridges:" + this.bridges);
    }



    // bridge helper functions
    // add bridge if that bridge isn't already in the list and if size < 3 and there is river there
    public void addBridge(int edge) {
        if(this.bridges.size() < 3 && !this.bridges.contains(Integer.valueOf(edge)) && this.riverEdges.contains(Integer.valueOf(edge))) {
            this.bridges.add(edge);
        }
    }

    public void removeBridge(int edge) {
        this.bridges.remove(Integer.valueOf(edge));
    }

    public ArrayList<Integer> getBridges() {
        return bridges;
    }

    public void setBridges(ArrayList<Integer> bridges) {
        this.bridges = bridges;
    }

    public boolean containsBridge(int i){
        if(bridges.contains(i)){
            return true;
        }
        else{
            return false;
        }
    }

}

