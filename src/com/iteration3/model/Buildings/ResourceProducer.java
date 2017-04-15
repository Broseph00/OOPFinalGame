package com.iteration3.model.Buildings;

public abstract class ResourceProducer {
    ProducerCapacity capacity;

    public ResourceProducer(int maxCapacity){
        capacity = new ProducerCapacity(maxCapacity);
    }

    public int getCurrentCapacity(){
        return capacity.getCapacity();
    }

    public void reset(){
        capacity.resetCapacity();
    }
}
