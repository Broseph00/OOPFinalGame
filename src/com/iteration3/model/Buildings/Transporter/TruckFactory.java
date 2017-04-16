package com.iteration3.model.Buildings.Transporter;

public class TruckFactory extends TransporterFactory {
    public TruckFactory() {
        super(1);
    }

    @Override
    public TransporterFactory upgrade() {
        return null;
    }
}
