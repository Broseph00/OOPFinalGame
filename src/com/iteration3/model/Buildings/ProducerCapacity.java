package com.iteration3.model.Buildings;

public class ProducerCapacity {
    private final int capacity;
    private int capacityUsage;

    public ProducerCapacity(int maxCapacity){
        if(maxCapacity < 0){
            throw new Error("maxCapacity must be greater than 0");

        }
        capacity = maxCapacity;
        capacityUsage = 0;
    }

    public int getCapacity(){
        return (capacity - capacityUsage);
    }

    public boolean decrementCapacity(){
        if(capacityUsage < capacity) {
            capacityUsage += 1;
            return true;
        } else {
            return false;
        }
    }

    public void resetCapacity(){
        capacityUsage = 0;
    }
}
