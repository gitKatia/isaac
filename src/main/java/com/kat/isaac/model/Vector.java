package com.kat.isaac.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public double dotProduct(Vector other) {
        Double xNew = this.x * other.x;
        Double yNew = this.y * other.y;
        Double zNew = this.z * other.z;
        return xNew + yNew + zNew;
    }

    public Vector multiply(double factor) {
        Double xNew = this.x * factor;
        Double yNew = this.y * factor;
        Double zNew = this.z * factor;
        return new Vector(xNew, yNew, zNew);
    }

    public Vector crossProduct(Vector other) {
        Double xNew = this.y * other.z - this.z * other.y;
        Double yNew = this.z * other.x - this.x * other.z;
        Double zNew = this.x * other.y - this.y * other.x;
        return new Vector(xNew, yNew, zNew);
    }

    public double modulus() {
        return Math.sqrt(this.dotProduct(this));
    }
}
