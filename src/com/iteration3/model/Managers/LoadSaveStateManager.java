package com.iteration3.model.Managers;


import com.iteration3.model.Map.Map;

public class LoadSaveStateManager {

    private String pathToSaveStateFile;
    private Map map;

    public LoadSaveStateManager(Map m, String path) {
        this.map = m;
        this.pathToSaveStateFile = path;
    }
}
