package com.iteration3.model;

import com.iteration3.model.Transporters.Transporter;

/**
 * Created by Clay on 4/16/2017.
 */
public interface TransporterIterator {

    public Transporter first();
    public void next();
    public void prev();
    public Transporter current();
}
