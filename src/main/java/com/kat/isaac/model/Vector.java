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

    public Double dotProduct(Vector other) {
        double xNew = this.x * other.x;
        double yNew = this.y * other.y;
        double zNew = this.z * other.z;
        return xNew + yNew + zNew;
    }

    public Vector multiply(double factor) {
        double xNew = this.x * factor;
        double yNew = this.y * factor;
        double zNew = this.z * factor;
        return new Vector(xNew, yNew, zNew);
    }

    public Vector crossProduct(Vector other) {
        Double xNew = this.y * other.z - this.z * other.y;
        Double yNew = this.z * other.x - this.x * other.z;
        Double zNew = this.x * other.y - this.y * other.x;
        return new Vector(xNew, yNew, zNew);
    }

    public Double modulus() {
        return Math.sqrt(this.dotProduct(this));
    }
}
