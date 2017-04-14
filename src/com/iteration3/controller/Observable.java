package com.iteration3.controller;

public interface Observable {

    public void addObserver(Observer obs);
    public void removeObserver(Observer obs);
    public void notifyAllObservers();
}
