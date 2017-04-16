package com.iteration3.model.Buildings.Transporter;

public class WagonFactory extends TransporterFactory {
    public WagonFactory() {
        super(1);
    }

    @Override
    public TransporterFactory upgrade() {
        return null;
    }
}
