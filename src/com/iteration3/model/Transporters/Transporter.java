package com.iteration3.model.Transporters;

import com.iteration3.model.Resource.Resource;

import java.util.List;

public abstract class Transporter {
    private List<Resource> resourceList;
    private int remainingMovePoints;
    private int maxMovePoints;
    private int capacity;
}
