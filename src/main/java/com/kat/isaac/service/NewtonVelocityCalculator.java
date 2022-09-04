package com.kat.isaac.service;

public class NewtonVelocityCalculator  implements VelocityCalculator {

    @Override
    public double circularOrbitVelocity(double semiAxis, double standardGravitationalParameter) {
        return Math.sqrt(standardGravitationalParameter / semiAxis);
    }

    @Override
    public double periApsVelocity(double semiAxis, double eccentricity, double standardGravitationalParameter) {
        return Math.sqrt(standardGravitationalParameter / semiAxis * (1 + eccentricity) / (1 - eccentricity));
    }

    @Override
    public double apoApsVelocity(double semiAxis, double eccentricity, double standardGravitationalParameter) {
        return Math.sqrt(standardGravitationalParameter / semiAxis * (1 - eccentricity) / (1 + eccentricity));
    }

    @Override
    public double escapeVelocity(double radius, double standardGravitationalParameter) {
        return Math.sqrt(2 * standardGravitationalParameter / radius);
    }
}
