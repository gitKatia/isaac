package com.kat.isaac.service;

import com.kat.isaac.model.CentralBody;
import com.kat.isaac.model.Orbit;
import com.kat.isaac.model.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.kat.isaac.AppConstants.PLANET_EARTH_NAME;
import static com.kat.isaac.TestHelper.*;
import static com.kat.isaac.model.MeasurementUnit.*;
import static com.kat.isaac.utils.OrbitsUtil.flightPathAngle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewtonOrbitCalculatorTest {
    private NewtonOrbitCalculator newtonOrbitCalculator = new NewtonOrbitCalculator();

    @DisplayName("orbit() given radius and velocity vectors")
    @Test
    void orbit_GivenRadiusAndVelocityVectors() {

        // Given
        CentralBody centralBody = CentralBody.builder()
                .name(PLANET_EARTH_NAME)
                .standardGravitationalParameter(standardGravitationalParameter(PLANET_EARTH_MASS))
                .meanEquatorialRadius(EARTH_MEAN_EQUATORIAL_RADIUS)
                .build();
        Vector radius = Vector.builder()
                .x(41852d)
                .y(62778d)
                .z(104630d)
                .build()
                .multiply(KILO * FT_IN_METERS);
        Vector velocity = Vector.builder()
                .x(25936d)
                .y(51872d)
                .build()
                .multiply(FT_IN_METERS);

        // When
        Orbit result = newtonOrbitCalculator.orbit(radius, velocity, centralBody);

        // Then
        assertDouble( "146089556%s46", result.getSpecificMechanicalEnergy());
        assertEquals("HYPERBOLA", result.getOrbitType());
        assertDouble( "565984341761%s75", result.getSpecificAngularMomentum());
        double flightPathAngle = flightPathAngle(radius, velocity);
        assertDouble("35%s48", flightPathAngle * RAD_IN_DEG);
    }

    @DisplayName("orbit() given specific mechanical Energy and eccentricity")
    @Test
    void orbit_GivenSpecificMechanicalEnergyAndEccentricity() {

        // Given
        CentralBody centralBody = CentralBody.builder()
                .name(PLANET_EARTH_NAME)
                .standardGravitationalParameter(standardGravitationalParameter(PLANET_EARTH_MASS))
                .meanEquatorialRadius(EARTH_MEAN_EQUATORIAL_RADIUS)
                .build();
        Double specificMechanicalEnergy = - 0.2 * GIGA * Math.pow(FT_IN_METERS, 2);
        Double eccentricity = 0.2;

        // When
        Orbit result = newtonOrbitCalculator.orbit(centralBody, specificMechanicalEnergy, eccentricity);

        // Then
        assertDouble( "-18580608", result.getSpecificMechanicalEnergy());
        assertEquals("ELLIPSE", result.getOrbitType());
        assertDouble( "64108804182%s74", result.getSpecificAngularMomentum());
        assertDouble( "10304058%s94", result.getParameter());
        assertDouble( "10733394%s73", result.getSemiAxis());
    }

    @DisplayName("orbit() given periApsHeight and eccentricity")
    @Test
    void orbit_GivenPeriApsHeightAndEccentricity() {

        // Given
        CentralBody centralBody = CentralBody.builder()
                .name(PLANET_EARTH_NAME)
                .standardGravitationalParameter(standardGravitationalParameter(PLANET_EARTH_MASS))
                .meanEquatorialRadius(EARTH_MEAN_EQUATORIAL_RADIUS)
                .build();
        Double periApsHeight = 200 * NM_IN_METERS;
        Double eccentricity = 0.1;

        // When
        Orbit result = newtonOrbitCalculator.orbit(periApsHeight, eccentricity, centralBody);

        // Then
        assertDouble( "-26596720%s93", result.getSpecificMechanicalEnergy());
        assertEquals("ELLIPSE", result.getOrbitType());
        assertDouble( "54414616051%s38", result.getSpecificAngularMomentum());
        assertDouble( "1870081%s11", result.getApoApsHeight());
    }
}
