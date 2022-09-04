package com.kat.isaac.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Orbit {
    private String orbitType;
    private Double eccentricity;
    private Double semiAxis;
    private Double specificMechanicalEnergy;
    private Double specificAngularMomentum;
    private Double parameter;
    private Double standardGravitationalParameter;
    private Double periApsRadius;
    private Double apoApsRadius;
    private Double periApsHeight;
    private Double apoApsHeight;
    private Double periApsVelocity;
    private Double apoApsVelocity;
    private Double period;
}
