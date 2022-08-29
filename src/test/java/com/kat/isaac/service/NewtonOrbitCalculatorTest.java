package com.kat.isaac.service;

import com.kat.isaac.model.Planet;
import com.kat.isaac.model.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import static com.kat.isaac.model.MeasurementUnit.FT;
import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NewtonOrbitCalculatorTest {

    private NewtonOrbitCalculator newtonOrbitCalculator = new NewtonOrbitCalculator();

    @DisplayName("circularOrbitVelocity()")
    @Test
    void circularOrbitVelocity() {

        // When
        double result = newtonOrbitCalculator.circularOrbitVelocity(42168000, Planet.EARTH);

        // Then
        assertTrue(result > 3000);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        char decimalFormatSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator();
        assertEquals(format("3075%s54", decimalFormatSeparator), df.format(result));
    }

    @DisplayName("specificMechanicalEnergy()")
    @Test
    void specificMechanicalEnergy() {

        // Given
        double radiusMultiplier = Math.pow(10, 7);
        Vector r = Vector.builder()
                .x(4.1852)
                .y(6.2778)
                .z(10.463)
                .build()
                .multiply(radiusMultiplier)
                .multiply(FT);

        double velocityMultiplier = Math.pow(10, 4);
        Vector v = Vector.builder()
                .x(2.5963)
                .y(5.1872)
                .build()
                .multiply(velocityMultiplier)
                .multiply(FT);

        double result = newtonOrbitCalculator.specificMechanicalEnergy(r, v, Planet.EARTH);
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        char decimalFormatSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator();
        assertEquals(format("146154647%s72", decimalFormatSeparator), df.format(result));
    }

    @DisplayName("specificAngularMomentum()")
    @Test
    void specificAngularMomentum() {

        // Given
        double radiusMultiplier = Math.pow(10, 7);
        Vector r = Vector.builder()
                .x(4.1852)
                .y(6.2778)
                .z(10.463)
                .build()
                .multiply(radiusMultiplier)
                .multiply(FT);

        double velocityMultiplier = Math.pow(10, 4);
        Vector v = Vector.builder()
                .x(2.5963)
                .y(5.1872)
                .build()
                .multiply(velocityMultiplier)
                .multiply(FT);

        // When
        double result = newtonOrbitCalculator.specificAngularMomentum(r, v);

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);
        char decimalFormatSeparator = DecimalFormatSymbols.getInstance().getDecimalSeparator();
        assertEquals(format("566087291925%s2", decimalFormatSeparator), df.format(result));
    }
}
