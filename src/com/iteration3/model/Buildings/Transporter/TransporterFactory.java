package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.Producer;
import com.iteration3.model.Transporters.Transporter;

public abstract class TransporterFactory extends Producer {
    public TransporterFactory() {
        super(1);
    }

    public abstract Transporter produce();
}
