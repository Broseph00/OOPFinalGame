package com.iteration3.model.Buildings.Secondary;

import com.iteration3.model.Buildings.ResourceRequirement;
import com.iteration3.model.Resource.*;

import java.util.ArrayList;

public class StockExchange extends SecondaryProducer {

    public StockExchange() {
        super(6);
        initialize();
    }

    public void initialize(){
        addRequirement(new Paper());
        addRequirement(new Coin());
        addRequirement(new Coin());
    }


    @Override
    public boolean checkResources(ResourceList availableResources) {
        if(availableResources.getPaper().size() >= 1 && availableResources.getCoins().size() >= 2) {
            availableResources.removePaper();
            availableResources.removeCoin();
            availableResources.removeCoin();
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Resource> produce(ResourceList availableResources) {

        boolean canProduce = checkResources(availableResources);
        ArrayList<Resource> stocks = new ArrayList<>();

        while(canProduce && getCapacity() > 0) {
            stocks.add(new Stock());
            decrementCapacity();
            canProduce = checkResources(availableResources);
        }

        return stocks;
    }
}
