package com.kat.isaac.isaac.service;

import com.kat.isaac.isaac.model.Planet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class NewtonOrbitCalculatorTest {
    private NewtonOrbitCalculator newtonOrbitCalculator = new NewtonOrbitCalculator();

    @DisplayName("circularOrbitVelocity()")
    @Test
    public void circularOrbitVelocity() {

        // When
        double result = newtonOrbitCalculator.circularOrbitVelocity(42168000, Planet.EARTH);

        // Then
        assertTrue(result > 3000);
    }
}
