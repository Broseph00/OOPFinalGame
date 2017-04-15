package com.iteration3.model.Buildings.Transporter;

public class RaftFactory extends TransporterFactory {
    public RaftFactory() {
        super(1);
    }

    @Override
    public TransporterFactory upgrade() {
        return null;
    }
}
