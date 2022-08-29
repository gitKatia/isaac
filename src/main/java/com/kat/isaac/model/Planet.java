package com.kat.isaac.model;

import com.kat.isaac.AppConstants;
import lombok.Getter;

import static com.kat.isaac.AppConstants.PLANET_EARTH;
import static com.kat.isaac.AppConstants.PLANET_MARS;

@Getter
public enum Planet {
    EARTH(PLANET_EARTH, AppConstants.PLANET_EARTH_MASS), MARS(PLANET_MARS, AppConstants.PLANET_MARS_MASS);

    private String planetName;
    private Double planetMass;

    Planet(String planetName, Double planetMass) {
        this.planetName = planetName;
        this.planetMass = planetMass;
    }

    public double standardGravitationalParameter() {
        return this.planetMass * AppConstants.G;
    }
}
