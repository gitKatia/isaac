package com.kat.isaac.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.kat.isaac.TestHelper.*;
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
        assertTrue(result > 3000);
        assertDouble("3075%s54", result);
    }
}
