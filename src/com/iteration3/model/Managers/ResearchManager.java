package com.iteration3.model.Managers;

import com.iteration3.utilities.Observable;
import com.iteration3.utilities.Observer;
import com.iteration3.model.Players.Research.*;
import com.iteration3.model.Visitors.ResearchTypeVisitor;

import java.util.ArrayList;

public class ResearchManager implements Observable{
    private ArrayList<Research> researchList;
    private boolean finishedEnlargementResearch;
    private boolean finishedNewShaftResearch;
    private boolean finishedOilResearch;
    private boolean finishedRowingResearch;
    private boolean finishedShipResearch;
    private boolean finishedSpecializationResearch;
    private boolean finishedTruckResearch;
    private ResearchTypeVisitor researchVisitor;

    public ResearchManager(){
        researchList = new ArrayList<>();
        init();
    }

    public void init(){
        researchList.add(new EnlargementResearch());
        researchList.add(new NewShaftResearch());
        researchList.add(new OilResearch());
        researchList.add(new RowingResearch());
        researchList.add(new ShipResearch());
        researchList.add(new SpecializationResearch());
        researchList.add(new TruckResearch());
        finishedEnlargementResearch = false;
        finishedNewShaftResearch = false;
        finishedOilResearch = false;
        finishedRowingResearch = false;
        finishedShipResearch = false;
        finishedSpecializationResearch = false;
        finishedTruckResearch = false;
        researchVisitor = new ResearchTypeVisitor();
    }

    public void completeResearch(EnlargementResearch research){
        researchList.remove(research);
        finishedEnlargementResearch = true;
    }

    public void completeResearch(NewShaftResearch research){
        researchList.remove(research);
        finishedNewShaftResearch = true;
    }

    public void completeResearch(OilResearch research){
        researchList.remove(research);
        finishedOilResearch = true;
    }

    public void completeResearch(RowingResearch research){
        researchList.remove(research);
        finishedRowingResearch = true;
    }

    public void completeResearch(ShipResearch research){
        researchList.remove(research);
        finishedShipResearch = true;
    }

    public void completeResearch(SpecializationResearch research){
        researchList.remove(research);
        finishedSpecializationResearch = true;
    }

    public void completeResearch(TruckResearch research){
        researchList.remove(research);
        finishedTruckResearch = true;
    }

    public ArrayList<Research> getResearchList() {
        return researchList;
    }

    public boolean isFinishedEnlargementResearch() {
        return finishedEnlargementResearch;
    }

    public boolean isFinishedNewShaftResearch() {
        return finishedNewShaftResearch;
    }

    public boolean isFinishedOilResearch() {
        return finishedOilResearch;
    }

    public boolean isFinishedRowingResearch() {
        return finishedRowingResearch;
    }

    public boolean isFinishedShipResearch() {
        return finishedShipResearch;
    }

    public boolean isFinishedSpecializationResearch() {
        return finishedSpecializationResearch;
    }

    public boolean isFinishedTruckResearch() {
        return finishedTruckResearch;
    }

    public String getResearchName(Research research){
        return research.getResearchType(researchVisitor);
    }

    @Override
    public void addObserver(Observer obs) {

    }

    @Override
    public void removeObserver(Observer obs) {

    }

    @Override
    public void notifyAllObservers() {

    }


    // add map as parameter
    // go through all tiles on map and check for 2 geese 1 paper
    // if this occurs, remove them from tile/transport
    // if there is a transport, get the player and give them option of research to complete

}
