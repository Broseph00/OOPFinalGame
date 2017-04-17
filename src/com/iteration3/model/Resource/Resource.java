package com.iteration3.model.Resource;

public abstract class Resource {
    public boolean equal(Resource otherResource){
        boolean equal = (otherResource.getClass() == this.getClass());
        return equal;
    }

    public abstract String getType();
}
