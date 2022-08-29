package com.kat.isaac.model;

public final class MeasurementUnit {

    private MeasurementUnit() {
    }

    public static Double FT_IN_METERS = 12 * 2.54 / 100;
    public static Double NM_IN_METERS = 1852d;
    public static Double RAD_IN_DEG = 180 / Math.PI;
}
