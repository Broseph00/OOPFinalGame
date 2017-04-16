package com.iteration3.model.Buildings.Transporter;

import com.iteration3.model.Buildings.Producer;

public abstract class TransporterFactory extends Producer {
    public TransporterFactory() {
        super(1);
    }

    public abstract TransporterFactory upgrade();
}
