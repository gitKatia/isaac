package com.kat.isaac.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CentralBody {
    private String name;
    private Double standardGravitationalParameter;
    private Double meanEquatorialRadius;
}
