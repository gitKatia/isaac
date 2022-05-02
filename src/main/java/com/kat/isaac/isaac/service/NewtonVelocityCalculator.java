package com.kat.isaac.isaac.service;


import static com.kat.isaac.isaac.AppConstants.*;

public class NewtonVelocityCalculator implements VelocityCalculator {

    @Override
    public double circularOrbitVelocity(double semiAxis, long planetId) {
        // Let's pretend it is always the Earth to generate the gravitational field
        return Math.sqrt(PLANET_EARTH_STANDARD_GRAVITATIONAL_PARAMETER / semiAxis);
    }

    @Override
    public double periApsVelocity(double a, double b, long planetId) {
        // Let's pretend it is always the Earth to generate the gravitational field
        double c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
        double rp = a - c;
        return Math.sqrt(2 * PLANET_EARTH_STANDARD_GRAVITATIONAL_PARAMETER * (1/rp - 1/(2*a)));
    }

    @Override
    public double apoApsVelocity(double a, double b, long planetId) {
        // Let's pretend it is always the Earth to generate the gravitational field
        double c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
        double ra = a + c;
        return Math.sqrt(2 * PLANET_EARTH_STANDARD_GRAVITATIONAL_PARAMETER * (1/ra - 1/(2*a)));
    }
}
