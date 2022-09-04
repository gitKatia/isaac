package com.kat.isaac.service;

public interface VelocityCalculator {
    double circularOrbitVelocity(double semiAxis, double standardGravitationalParameter);
    double periApsVelocity(double semiAxis, double eccentricity, double standardGravitationalParameter);
    double apoApsVelocity(double semiAxis, double eccentricity, double standardGravitationalParameter);
    double escapeVelocity(double radius, double standardGravitationalParameter);
}
