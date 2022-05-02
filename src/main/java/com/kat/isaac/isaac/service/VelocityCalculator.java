package com.kat.isaac.isaac.service;

public interface VelocityCalculator {
    double circularOrbitVelocity(double semiAxis, long planetId);
    double periApsVelocity(double a, double b, long planetId);
    double apoApsVelocity(double a, double b, long planetId);
}
