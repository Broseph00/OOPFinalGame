package com.iteration3.model.Map;

import java.util.ArrayList;

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

    public void addBridge(Integer edge){

    }
}
