package com.kat.isaac.service;

import com.kat.isaac.model.Planet;
import com.kat.isaac.model.Vector;

public interface OrbitCalculator {
    double circularOrbitVelocity(double semiAxis, Planet planet);
    double periApsVelocity(double a, double b, Planet planet);
    double apoApsVelocity(double a, double b, Planet planet);
    double escapeVelocity(Planet planet, double r);
    double period(double semiAxis, Planet planet);
    double specificMechanicalEnergy(Vector r, Vector v, Planet planet);
    double specificAngularMomentum(Vector r, Vector v);
    double flightPathAngle(Vector r, Vector v);
    double period(Planet planet, double semiaxis);
}
