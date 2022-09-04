package com.kat.isaac.service;

import com.kat.isaac.model.CentralBody;
import com.kat.isaac.model.Orbit;
import com.kat.isaac.model.Vector;

public interface OrbitCalculator {
    Orbit orbit(Vector r, Vector v, CentralBody centralBody);
    Orbit orbit2(Double specificMechanicalEnergy, Double eccentricity, CentralBody centralBody);
    Orbit orbit(Double periApsHeight, Double eccentricity, CentralBody centralBody);
    Orbit orbit(Double height, Double velocity, Double flightPathAngle, CentralBody centralBody);
}
