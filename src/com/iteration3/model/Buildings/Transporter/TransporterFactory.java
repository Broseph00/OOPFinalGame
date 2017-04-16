package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.Producer;

public abstract class TransporterFactory extends Producer {
    public TransporterFactory(int maxCapacity) {
        super(maxCapacity);
    }

    public abstract TransporterFactory upgrade();
}
