package com.iteration3.model.Buildings.Transporter;

public class SteamerFactory extends TransporterFactory {
    public SteamerFactory() {
        super(1);
    }

    @Override
    public TransporterFactory upgrade() {
        return null;
    }
}
