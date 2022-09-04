package com.kat.isaac.service;


import com.kat.isaac.model.CentralBody;
import com.kat.isaac.model.Orbit;
import com.kat.isaac.model.Vector;
import com.kat.isaac.service.interfaces.OrbitCalculator;

import static com.kat.isaac.utils.OrbitsUtil.*;

public class NewtonOrbitCalculator implements OrbitCalculator {

    @Override
    public Orbit orbit(Vector r, Vector v, CentralBody centralBody) {
        Double standardGravitationalParameter = centralBody.getStandardGravitationalParameter();
        Double specificMechanicalEnergy = v.dotProduct(v) /2 - standardGravitationalParameter / r.modulus();
        String orbitType = orbitType(specificMechanicalEnergy);
        Double semiAxis = semiAxis(specificMechanicalEnergy, standardGravitationalParameter);
        Double specificAngularMomentum = r.crossProduct(v).modulus();
        Double parameter = Math.pow(specificAngularMomentum, 2) / 2;
        Double eccentricity = eccentricity(parameter, semiAxis, orbitType);
        Double periApsRadius = parameter / (1 + eccentricity);
        Double apoApsRadius = apoApsRadius(parameter, eccentricity, orbitType);
        Double meanEquatorialRadius = centralBody.getMeanEquatorialRadius();
        Double periApsVelocity = Math.sqrt(2 * (specificMechanicalEnergy  + standardGravitationalParameter / periApsRadius));
        Double apoApsVelocity = apoApsVelocity(apoApsRadius, specificMechanicalEnergy, standardGravitationalParameter, orbitType);
        return Orbit.builder()
                .specificMechanicalEnergy(specificMechanicalEnergy)
                .orbitType(orbitType)
                .semiAxis(semiAxis)
                .specificAngularMomentum(specificAngularMomentum)
                .parameter(parameter)
                .eccentricity(eccentricity)
                .periApsRadius(periApsRadius)
                .apoApsRadius(apoApsRadius)
                .periApsHeight(periApsRadius - meanEquatorialRadius)
                .apoApsHeight(apoApsHeight(apoApsRadius, meanEquatorialRadius, orbitType))
                .periApsVelocity(periApsVelocity)
                .apoApsVelocity(apoApsVelocity)
                .standardGravitationalParameter(standardGravitationalParameter)
                .period(period(semiAxis, standardGravitationalParameter, orbitType))
                .build();
    }

    @Override
    public Orbit orbit(CentralBody centralBody, Double specificMechanicalEnergy, Double eccentricity) {
        Double standardGravitationalParameter = centralBody.getStandardGravitationalParameter();
        Double meanEquatorialRadius = centralBody.getMeanEquatorialRadius();
        Double semiAxis = semiAxis(specificMechanicalEnergy, standardGravitationalParameter);
        String orbitType = orbitType(specificMechanicalEnergy);
        Double apoApsRadius = apoApsRadiusFromSemiAxis(semiAxis, eccentricity, orbitType);
        Double apoApsVelocity = apoApsVelocity(apoApsRadius, specificMechanicalEnergy, standardGravitationalParameter, orbitType);
        Double parameter = parameter(semiAxis, eccentricity, orbitType);
        Double specificAngularMomentum = specificAngularMomentum(parameter, standardGravitationalParameter);
        Double periApsRadius = periApsRadius(parameter, eccentricity);
        Double periApsVelocity = periApsVelocity(periApsRadius, specificMechanicalEnergy, standardGravitationalParameter);
        return Orbit.builder()
                .eccentricity(eccentricity)
                .parameter(parameter)
                .periApsRadius(periApsRadius)
                .apoApsRadius(apoApsRadius)
                .periApsHeight(periApsHeight(periApsRadius, meanEquatorialRadius))
                .apoApsHeight(apoApsHeight(apoApsRadius, meanEquatorialRadius, orbitType))
                .apoApsVelocity(apoApsVelocity)
                .periApsVelocity(periApsVelocity)
                .semiAxis(semiAxis)
                .standardGravitationalParameter(standardGravitationalParameter)
                .specificMechanicalEnergy(specificMechanicalEnergy)
                .orbitType(orbitType)
                .specificAngularMomentum(specificAngularMomentum)
                .period(period(semiAxis, standardGravitationalParameter, orbitType))
                .build();
    }

    @Override
    public Orbit orbit(Double periApsHeight, Double eccentricity, CentralBody centralBody) {
        Double standardGravitationalParameter = centralBody.getStandardGravitationalParameter();
        Double meanEquatorialRadius = centralBody.getMeanEquatorialRadius();
        String orbitType = orbitTypeFromEccentricity(eccentricity);
        Double periApsRadius = periApsHeight + meanEquatorialRadius;
        Double semiAxis = semiAxis(periApsRadius, eccentricity, orbitType);
        Double parameter = periApsRadius * (1 + eccentricity);
        Double apoApsRadius = apoApsRadius(parameter, eccentricity, orbitType);
        Double specificAngularMomentum = Math.sqrt(standardGravitationalParameter * parameter);
        Double periApsVelocity = specificAngularMomentum / periApsRadius;
        Double specificMechanicalEnergy = Math.pow(periApsVelocity, 2) / 2 - standardGravitationalParameter / periApsRadius;
        Double apoApsVelocity = apoApsVelocity(apoApsRadius, specificMechanicalEnergy, standardGravitationalParameter, orbitType);
        return Orbit.builder()
                .eccentricity(eccentricity)
                .parameter(parameter)
                .periApsRadius(periApsRadius)
                .apoApsRadius(apoApsRadius)
                .periApsHeight(periApsHeight)
                .apoApsHeight(apoApsHeight(apoApsRadius, meanEquatorialRadius, orbitType))
                .apoApsVelocity(apoApsVelocity)
                .periApsVelocity(periApsVelocity)
                .semiAxis(semiAxis)
                .standardGravitationalParameter(standardGravitationalParameter)
                .specificMechanicalEnergy(specificMechanicalEnergy)
                .orbitType(orbitType)
                .specificAngularMomentum(specificAngularMomentum)
                .period(period(semiAxis, standardGravitationalParameter, orbitType))
                .build();
    }

    @Override
    public Orbit orbit(Double height, Double velocity, Double flightPathAngle, CentralBody centralBody) {

        Double standardGravitationalParameter = centralBody.getStandardGravitationalParameter();
        Double meanEquatorialRadius = centralBody.getMeanEquatorialRadius();
        Double radius = height + centralBody.getMeanEquatorialRadius();
        Double specificMechanicalEnergy = Math.pow(velocity, 2) / 2 - standardGravitationalParameter / radius;
        String orbitType = orbitType(specificMechanicalEnergy);
        Double semiAxis = semiAxis(specificMechanicalEnergy, standardGravitationalParameter);
        Double specificAngularMomentum = radius * velocity * Math.sin(Math.PI/2 - flightPathAngle);
        Double parameter = Math.pow(specificAngularMomentum, 2) / standardGravitationalParameter;
        Double eccentricity = eccentricity(parameter, semiAxis, orbitType);
        Double periApsRadius = parameter / (1 + eccentricity);
        Double apoApsRadius = apoApsRadius(parameter, eccentricity, orbitType);
        Double periApsVelocity = Math.sqrt(2 * (specificMechanicalEnergy  + standardGravitationalParameter / periApsRadius));
        Double apoApsVelocity = apoApsVelocity(apoApsRadius, specificMechanicalEnergy, standardGravitationalParameter, orbitType);
        return Orbit.builder()
                .eccentricity(eccentricity)
                .parameter(parameter)
                .periApsRadius(periApsRadius)
                .apoApsRadius(apoApsRadius)
                .periApsHeight(periApsRadius - meanEquatorialRadius)
                .apoApsHeight(apoApsHeight(apoApsRadius, meanEquatorialRadius, orbitType))
                .apoApsVelocity(apoApsVelocity)
                .periApsVelocity(periApsVelocity)
                .semiAxis(semiAxis)
                .standardGravitationalParameter(standardGravitationalParameter)
                .specificMechanicalEnergy(specificMechanicalEnergy)
                .orbitType(orbitType)
                .specificAngularMomentum(specificAngularMomentum)
                .period(period(semiAxis, standardGravitationalParameter, orbitType))
                .build();
    }

    @Override
    public Orbit orbitFromParameterAndVelocityAtParameter(Double parameter, Double velocity, CentralBody centralBody) {
        Double standardGravitationalParameter = centralBody.getStandardGravitationalParameter();
        Double meanEquatorialRadius = centralBody.getMeanEquatorialRadius();
        Double specificMechanicalEnergy = specificMechanicalEnergy(parameter, velocity, standardGravitationalParameter);
        String orbitType = orbitType(specificMechanicalEnergy);
        Double semiAxis = semiAxis(specificMechanicalEnergy, standardGravitationalParameter);
        Double eccentricity = eccentricity(parameter, semiAxis, orbitType);
        Double periApsRadius = periApsRadius(parameter, eccentricity);
        Double apoApsRadius = apoApsRadius(parameter, eccentricity, orbitType);
        return Orbit.builder()
                .eccentricity(eccentricity)
                .parameter(parameter)
                .periApsRadius(periApsRadius)
                .apoApsRadius(apoApsRadius)
                .periApsHeight(periApsRadius - meanEquatorialRadius)
                .apoApsHeight(apoApsHeight(apoApsRadius, meanEquatorialRadius, orbitType))
                .apoApsVelocity(apoApsVelocity(apoApsRadius, specificMechanicalEnergy, standardGravitationalParameter, orbitType))
                .periApsVelocity(periApsVelocity(periApsRadius, specificMechanicalEnergy, standardGravitationalParameter))
                .semiAxis(semiAxis)
                .standardGravitationalParameter(standardGravitationalParameter)
                .specificMechanicalEnergy(specificMechanicalEnergy)
                .orbitType(orbitType)
                .specificAngularMomentum(specificAngularMomentum(parameter, standardGravitationalParameter))
                .period(period(semiAxis, standardGravitationalParameter, orbitType))
                .build();
    }
}
