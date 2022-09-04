package com.kat.isaac.model;

public final class MeasurementUnit {

    private MeasurementUnit() {
    }

    public static Double FT_IN_METERS = 12 * 2.54 / 100;
    public static Double NM_IN_METERS = 1852d;
    public static Double RAD_IN_DEG = 180 / Math.PI;
    public static Double KILO = 1000d;
    public static Double MEGA = 1000_000d;
    public static Double GIGA = 1000_000_000d;
    public static Double TERA = 1000_000_000_000d;
    public static Double PETA = 1000_000_000_000_000d;
}
