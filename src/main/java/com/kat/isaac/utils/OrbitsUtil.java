package com.kat.isaac.utils;

import com.kat.isaac.model.Vector;

import static com.kat.isaac.AppConstants.*;

public final class OrbitsUtil {

    private OrbitsUtil() {
    }

    public static String orbitType(Double specificMechanicalEnergy) {
        double zero = Math.pow(10, - 5);
        if (Math.abs(specificMechanicalEnergy) < zero) {
            return PARABOLA_CONIC_TYPE;
        }
        return specificMechanicalEnergy > 0 ? HYPERBOLA_CONIC_TYPE : ELLIPSE_CONIC_TYPE;
    }

    public static String orbitTypeFromEccentricity(Double eccentricity) {
        double zero = Math.pow(10, - 5);
        if (Math.abs(eccentricity) < (1.0 + zero) && Math.abs(eccentricity) > (1.0 - zero)) {
            return PARABOLA_CONIC_TYPE;
        }
        return eccentricity > 1 ? HYPERBOLA_CONIC_TYPE : ELLIPSE_CONIC_TYPE;
    }

    public static Double semiAxis(Double specificMechanicalEnergy, Double standardGravitationalParameter) {
        double zero = Math.pow(10, - 5);
        if (Math.abs(specificMechanicalEnergy) < zero) {
            return Double.POSITIVE_INFINITY;
        }
        return - standardGravitationalParameter / (2 * specificMechanicalEnergy);
    }

    public static Double semiAxis(Double periApsRadius, Double eccentricity, String orbitType) {
        if (! ELLIPSE_CONIC_TYPE.equals(orbitType)) {
            return Double.POSITIVE_INFINITY;
        }
        return periApsRadius / (1 - eccentricity);
    }

    public static Double parameter(Double semiAxis, Double eccentricity, String orbitType) {
        if (PARABOLA_CONIC_TYPE.equals(orbitType)) {
            return null;
        }
        return semiAxis * (1 - Math.pow(eccentricity, 2));
    }

    public static Double specificAngularMomentum(Double parameter, Double standardGravitationalParameter) {
        return parameter != null ? Math.sqrt(parameter * standardGravitationalParameter) : null;
    }

    public static Double eccentricity(Double parameter, Double semiAxis, String orbitType) {
        if (PARABOLA_CONIC_TYPE.equals(orbitType)) {
            return 1.0;
        }
        return Math.sqrt(1 - parameter/semiAxis);
    }

    public static Double apoApsRadius(Double parameter, Double eccentricity, String orbitType) {
        if (! ELLIPSE_CONIC_TYPE.equals(orbitType)) {
            return Double.POSITIVE_INFINITY;
        }
        return parameter / (1 - eccentricity);
    }

    public static Double periApsRadius(Double parameter, Double eccentricity) {
        return parameter != null ? parameter / (1 + eccentricity) : null;
    }

    public static Double apoApsRadiusFromSemiAxis(Double semiAxis, Double eccentricity, String orbitType) {
        if (! ELLIPSE_CONIC_TYPE.equals(orbitType)) {
            return Double.POSITIVE_INFINITY;
        }

        return semiAxis * (1 + eccentricity);
    }

    public static Double apoApsVelocity(Double apoApsRadius, Double specificMechanicalEnergy, Double standardGravitationalParameter,
                                        String orbitType) {
        if ("PARABOLA".equals(orbitType)) {
            return 0.0;
        }
        if (HYPERBOLA_CONIC_TYPE.equals(orbitType)) {
            return Math.sqrt(2 * specificMechanicalEnergy);
        }
        return Math.sqrt(2 * (specificMechanicalEnergy  + standardGravitationalParameter / apoApsRadius));
    }

    public static Double periApsVelocity(Double periApsRadius, Double specificMechanicalEnergy, Double standardGravitationalParameter) {
        return  periApsRadius != null ? Math.sqrt(2 * (specificMechanicalEnergy  + standardGravitationalParameter / periApsRadius)) : null;
    }

    public static Double period(Double semiAxis, Double standardGravitationalParameter, String orbitType) {
        if (! ELLIPSE_CONIC_TYPE.equals(orbitType)) {
            return Double.POSITIVE_INFINITY;
        }
        return 2 * Math.PI/Math.sqrt(standardGravitationalParameter) * Math.sqrt(Math.pow(semiAxis, 3));
    }

    public static Double apoApsHeight(Double apoApsRadius, Double meanEquatorialRadius, String orbitType) {
        if (! ELLIPSE_CONIC_TYPE.equals(orbitType)) {
            return Double.POSITIVE_INFINITY;
        }
        return apoApsRadius != null ? apoApsRadius - meanEquatorialRadius : null;
    }

    public static Double periApsHeight(Double periApsRadius, Double meanEquatorialRadius) {
        return periApsRadius != null ? periApsRadius - meanEquatorialRadius : null;
    }

    public static double flightPathAngle(Vector r, Vector v) {
        double cosZenith = r.dotProduct(v) / (r.modulus() * v.modulus());
        double sinFlightPathAngle = cosZenith;
        return Math.asin(sinFlightPathAngle);
    }
}


