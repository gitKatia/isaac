package com.kat.isaac.service.interfaces;

import com.kat.isaac.model.CentralBody;
import com.kat.isaac.model.Orbit;
import com.kat.isaac.model.Vector;

public interface OrbitCalculator {
    Orbit orbit(Vector r, Vector v, CentralBody centralBody);
    Orbit orbit(CentralBody centralBody, Double specificMechanicalEnergy, Double eccentricity);
    Orbit orbit(Double periApsHeight, Double eccentricity, CentralBody centralBody);
    Orbit orbit(Double height, Double velocity, Double flightPathAngle, CentralBody centralBody);
}
