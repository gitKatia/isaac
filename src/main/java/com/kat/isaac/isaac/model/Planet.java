package com.kat.isaac.isaac.model;

import static com.kat.isaac.isaac.AppConstants.*;

public enum Planet {
    EARTH(1, PLANET_EARTH_MASS), MARS(2, PLANET_MARS_MASS);

    private long planetId;
    private Double planetMass;

    Planet(long planetId, Double planetMass) {
        this.planetId = planetId;
        this.planetMass = planetMass;
    }

    public long getPlanetId() {
        return planetId;
    }

    public Double getPlanetMass() {
        return planetMass;
    }

    public double standardGravitationalParameter() {
        return this.planetMass * G;
    }
}
