package com.kat.isaac;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static com.kat.isaac.AppConstants.G;
import static com.kat.isaac.model.MeasurementUnit.KILO;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

public interface TestHelper {
    Double PLANET_EARTH_MASS = 5.98 * Math.pow(10, 24);
    Double PLANET_MARS_MASS = 6.39 * Math.pow(10, 23);
    Double STAR_SUN_MASS = 1.989 * Math.pow(10, 30);
    Double EARTH_MOON_MASS = 1.0 * Math.pow(10, 24);
    Double EARTH_MEAN_EQUATORIAL_RADIUS = 6378.165 * KILO;

    static Double standardGravitationalParameter(Double centralBodyMass) {
        return G * centralBodyMass;
    }

    static void assertDouble(String expectation, Double result) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        char decimalFormatSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator();
        assertEquals(format(expectation, decimalFormatSeparator), df.format(result));
    }
}
