package com.iteration3.model;

import com.iteration3.model.Abilities.Ability;

/**
 * Created by Clay on 4/16/2017.
 */
public interface AbilityIterator {

    public Ability first();
    public void next();
    public void prev();
    public Ability current();
}
