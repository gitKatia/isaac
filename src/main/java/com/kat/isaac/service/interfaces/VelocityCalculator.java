package com.kat.isaac.service.interfaces;

public interface VelocityCalculator {
    double circularOrbitVelocity(double semiAxis, double standardGravitationalParameter);
    double periApsVelocity(double semiAxis, double eccentricity, double standardGravitationalParameter);
    double apoApsVelocity(double semiAxis, double eccentricity, double standardGravitationalParameter);
    double escapeVelocity(double radius, double standardGravitationalParameter);
    double velocity(double radius, double specificMechanicalEnergy, double standardGravitationalParameter);
}
