package com.iteration3.model.Buildings;

public abstract class Producer {
    int capacity;
    private int capacityUsage;

    public Producer(int maxCapacity){
        if(maxCapacity < 1){
            throw new Error("maxCapacity must be greater than 0");

        }
        capacity = maxCapacity;
        capacityUsage = 0;
    }

    public abstract String getType();

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
