package com.kat.isaac;

import static com.kat.isaac.AppConstants.G;
import static com.kat.isaac.model.MeasurementUnit.KILO;

public interface TestHelper {
    Double PLANET_EARTH_MASS = 5.98 * Math.pow(10, 24);
    Double PLANET_MARS_MASS = 6.39 * Math.pow(10, 23);
    Double STAR_SUN_MASS = 1.989 * Math.pow(10, 30);
    Double EARTH_MOON_MASS = 1.0 * Math.pow(10, 24);
    Double EARTH_MEAN_EQUATORIAL_RADIUS = 6378.165 * KILO;

    static double standardGravitationalParameter(double centralBodyMass) {
        return G * centralBodyMass;
    }
}
