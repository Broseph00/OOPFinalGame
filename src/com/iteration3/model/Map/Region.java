package com.iteration3.model.Map;

import java.util.ArrayList;
import java.util.Iterator;

public class Region {
    private ArrayList<ArrayList<Integer>> regions;
    public Region(){
        regions = new ArrayList<>();
        ArrayList<Integer> init = new ArrayList<>();
        init.add(1);
        init.add(2);
        init.add(3);
        init.add(4);
        init.add(5);
        init.add(6);
        regions.add(init);
    }

    public void addRiver(River river){
        if(river.getNumOfEdges()>1){
            regions.clear();
            if(river.getNumOfEdges()==2){
                ArrayList<Integer> region1 = new ArrayList<>();
                ArrayList<Integer> region2 = new ArrayList<>();
                if(river.containsRiverEdge(1)){
                    if(river.containsRiverEdge(2)){
                        region1.add(1);
                        region2.add(2);
                        region2.add(3);
                        region2.add(4);
                        region2.add(5);
                        region2.add(6);
                    }
                    else if(river.containsRiverEdge(3)){
                        region1.add(1);
                        region1.add(2);
                        region2.add(3);
                        region2.add(4);
                        region2.add(5);
                        region2.add(6);
                    }
                    else if(river.containsRiverEdge(4)){
                        region1.add(1);
                        region1.add(2);
                        region1.add(3);
                        region2.add(4);
                        region2.add(5);
                        region2.add(6);
                    }
                    else if(river.containsRiverEdge(5)){
                        region1.add(1);
                        region1.add(2);
                        region1.add(3);
                        region1.add(4);
                        region2.add(5);
                        region2.add(6);
                    }
                    else if(river.containsRiverEdge(6)){
                        region1.add(1);
                        region1.add(2);
                        region1.add(3);
                        region1.add(4);
                        region1.add(5);
                        region2.add(6);
                    }
                }
                else if(river.containsRiverEdge(2)){
                    if(river.containsRiverEdge(3)){
                        region1.add(2);
                        region2.add(3);
                        region2.add(4);
                        region2.add(5);
                        region2.add(6);
                        region2.add(1);
                    }
                    else if(river.containsRiverEdge(4)){
                        region1.add(2);
                        region1.add(3);
                        region2.add(4);
                        region2.add(5);
                        region2.add(6);
                        region2.add(1);
                    }
                    else if(river.containsRiverEdge(5)){
                        region1.add(2);
                        region1.add(3);
                        region1.add(4);
                        region2.add(5);
                        region2.add(6);
                        region2.add(1);
                    }
                    else if(river.containsRiverEdge(6)){
                        region1.add(2);
                        region1.add(3);
                        region1.add(4);
                        region1.add(5);
                        region2.add(6);
                        region2.add(1);
                    }
                }
                else if(river.containsRiverEdge(3)){
                    if(river.containsRiverEdge(4)){
                        region1.add(3);
                        region2.add(4);
                        region2.add(5);
                        region2.add(6);
                        region2.add(1);
                        region2.add(2);
                    }
                    else if(river.containsRiverEdge(5)){
                        region1.add(3);
                        region1.add(4);
                        region2.add(5);
                        region2.add(6);
                        region2.add(1);
                        region2.add(2);
                    }
                    else if(river.containsRiverEdge(6)){
                        region1.add(3);
                        region1.add(4);
                        region1.add(5);
                        region2.add(6);
                        region2.add(1);
                        region2.add(2);
                    }
                }
                else if(river.containsRiverEdge(4)){
                    if(river.containsRiverEdge(5)){
                        region1.add(4);
                        region2.add(5);
                        region2.add(6);
                        region2.add(1);
                        region2.add(2);
                        region2.add(3);
                    }
                    else if(river.containsRiverEdge(6)){
                        region1.add(4);
                        region1.add(5);
                        region2.add(6);
                        region2.add(1);
                        region2.add(2);
                        region2.add(3);
                    }
                }
                else if(river.containsRiverEdge(5)){
                    region1.add(5);
                    region2.add(6);
                    region2.add(1);
                    region2.add(2);
                    region2.add(3);
                    region2.add(4);
                }
                regions.add(region1);
                regions.add(region2);
            }
            else if(river.getNumOfEdges()==3){
                ArrayList<Integer> region1 = new ArrayList<>();
                ArrayList<Integer> region2 = new ArrayList<>();
                ArrayList<Integer> region3 = new ArrayList<>();
                if(river.containsRiverEdge(1)){
                    region1.add(1);
                    region1.add(2);
                    region2.add(3);
                    region2.add(4);
                    region3.add(5);
                    region3.add(6);
                }
                else if(river.containsRiverEdge(2)){
                    region1.add(2);
                    region1.add(3);
                    region2.add(4);
                    region2.add(5);
                    region3.add(6);
                    region3.add(1);
                }
                regions.add(region1);
                regions.add(region2);
                regions.add(region3);
            }
        }
    }

    private void removeRegion(ArrayList<Integer> regionToRemove){
        regions.remove(regionToRemove);
    }

    public void addBridge(Integer edge){
        if(edge>=1 && edge <=6) {
            ArrayList<Integer> region1;
            ArrayList<Integer> region2 = new ArrayList<>();
            if (edge == 1) {
                if (!connected(6, 1)) {
                    region1=getRegion(6);
                    region2=getRegion(1);
                    region1.addAll(region2);
                }
            } else if (edge == 2) {
                if (!connected(1, 2)) {
                    region1=getRegion(1);
                    region2=getRegion(2);
                    region1.addAll(region2);
                }
            } else if (edge == 3) {
                if (!connected(2, 3)) {
                    region1=getRegion(2);
                    region2=getRegion(3);
                    region1.addAll(region2);
                }
            } else if (edge == 4) {
                if (!connected(3, 4)) {
                    region1=getRegion(3);
                    region2=getRegion(4);
                    region1.addAll(region2);
                }
            } else if (edge == 5) {
                if (!connected(4, 5)) {
                    region1=getRegion(4);
                    region2=getRegion(5);
                    region1.addAll(region2);
                }
            } else if (edge == 6) {
                if (!connected(5, 6)) {
                    region1=getRegion(5);
                    region2=getRegion(6);
                    region1.addAll(region2);
                }
            }
            removeRegion(region2);
        }
    }

    public boolean connected(int x, int y){
        return getRegion(x) == getRegion(y);
    }

    public ArrayList<Integer> getRegion(int x){
        Iterator<ArrayList<Integer>> outer = regions.iterator();
        while(outer.hasNext()){
            ArrayList<Integer> region = outer.next();
            Iterator<Integer> inner = region.iterator();
            while(inner.hasNext()){
                if(x==inner.next()){
                    return region;
                }
            }
        }
        //Return empty region if it doesn't exist
        ArrayList<Integer> empty = new ArrayList<>();
        return empty;
    }

    public void printRegion(){
        Iterator<ArrayList<Integer>> outer = regions.iterator();
        while(outer.hasNext()){
            System.out.println("");
            ArrayList<Integer> region = outer.next();
            Iterator<Integer> inner = region.iterator();
            while(inner.hasNext()){
                System.out.print(inner.next() + " ");
            }
        }
    }
}
