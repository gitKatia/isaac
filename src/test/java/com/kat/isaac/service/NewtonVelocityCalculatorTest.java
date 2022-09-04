package com.kat.isaac.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.kat.isaac.TestHelper.*;
import static com.kat.isaac.model.MeasurementUnit.NM_IN_METERS;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NewtonVelocityCalculatorTest {

    private NewtonVelocityCalculator newtonVelocityCalculator = new NewtonVelocityCalculator();

    @DisplayName("circularOrbitVelocity()")
    @Test
    void circularOrbitVelocity() {

        // Given
        double standardGravitationalParameter = standardGravitationalParameter(PLANET_EARTH_MASS);

        // When
        Double result = newtonVelocityCalculator.circularOrbitVelocity(42168000, standardGravitationalParameter);

        // Then
        assertDouble("3075%s54", result);
    }

    @DisplayName("escapeVelocity()")
    @Test
    void escapeVelocity() {

        // Given
        Double height = 100 * NM_IN_METERS;
        double earthMeanEquatorialRadius =  EARTH_MEAN_EQUATORIAL_RADIUS;
        Double radius = height + earthMeanEquatorialRadius;
        double standardGravitationalParameter = standardGravitationalParameter(PLANET_EARTH_MASS);

        // When
        Double result = newtonVelocityCalculator.escapeVelocity(radius, standardGravitationalParameter);

        // Then
        assertDouble("11024%s66", result);
    }
}
