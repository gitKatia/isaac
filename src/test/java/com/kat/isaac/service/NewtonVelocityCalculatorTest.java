package com.kat.isaac.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static com.kat.isaac.TestHelper.PLANET_EARTH_MASS;
import static com.kat.isaac.TestHelper.standardGravitationalParameter;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NewtonVelocityCalculatorTest {

    private NewtonVelocityCalculator newtonVelocityCalculator = new NewtonVelocityCalculator();

    @DisplayName("circularOrbitVelocity()")
    @Test
    void circularOrbitVelocity() {

        // Given
        double standardGravitationalParameter = standardGravitationalParameter(PLANET_EARTH_MASS);

        // When
        double result = newtonVelocityCalculator.circularOrbitVelocity(42168000, standardGravitationalParameter);

        // Then
        assertTrue(result > 3000);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        char decimalFormatSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator();
        assertEquals(format("3075%s54", decimalFormatSeparator), df.format(result));
    }
}
