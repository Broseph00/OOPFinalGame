package com.iteration3.model.Buildings.Transporter;

public class RowboatFactory extends TransporterFactory {
    public RowboatFactory() {
        super(1);
    }

    @Override
    public TransporterFactory upgrade() {
        return null;
    }
}
