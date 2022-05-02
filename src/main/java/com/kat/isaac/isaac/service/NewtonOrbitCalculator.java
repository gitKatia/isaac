package com.kat.isaac.isaac.service;


import com.kat.isaac.isaac.model.Planet;

public class NewtonOrbitCalculator implements OrbitCalculator {

    @Override
    public double circularOrbitVelocity(double semiAxis, Planet planet) {
        return Math.sqrt(planet.standardGravitationalParameter() / semiAxis);
    }

    @Override
    public double periApsVelocity(double a, double b, Planet planet) {
        double c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
        double rp = a - c;
        return Math.sqrt(2 * planet.standardGravitationalParameter() * (1/rp - 1/(2*a)));
    }

    @Override
    public double apoApsVelocity(double a, double b, Planet planet) {
        double c = Math.sqrt(Math.pow(a, 2) - Math.pow(b, 2));
        double ra = a + c;
        return Math.sqrt(2 * planet.standardGravitationalParameter() * (1/ra - 1/(2*a)));
    }

    @Override
    public double escapeVelocity(Planet planet) {
        return 0;
    }

    @Override
    public double period(double semiAxis, Planet planet) {
        return 0;
    }
}
