package com.kat.isaac.isaac.service;

import com.kat.isaac.isaac.model.Planet;

public interface OrbitCalculator {
    double circularOrbitVelocity(double semiAxis, Planet planet);
    double periApsVelocity(double a, double b, Planet planet);
    double apoApsVelocity(double a, double b, Planet planet);
    double escapeVelocity(Planet planet);
    double period(double semiAxis, Planet planet);
}
