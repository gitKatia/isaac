package model;

import com.kat.isaac.model.Vector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorTest {

    @DisplayName("modulus returns 0 given null vector")
    @Test
    void modulusReturns0_GivenNullVector() {

        // Given
        Vector vector = Vector.builder()
                .build();

        // Then
        assertEquals(0, vector.modulus());
    }

    @DisplayName("modulus returns x projection given vector has only x coordinate")
    @Test
    void modulusReturnsXProjection_GivenVectorHasOnlyXCoordinate() {

        // Given
        Vector vector = Vector.builder()
                .x(3.5)
                .build();

        // Then
        assertEquals(3.5, vector.modulus());
    }

    @DisplayName("modulus returns y projection given vector has only y coordinate")
    @Test
    void modulusReturnsYProjection_GivenVectorHasOnlyYCoordinate() {

        // Given
        Vector vector = Vector.builder()
                .y(3.5)
                .build();

        // Then
        assertEquals(3.5, vector.modulus());
    }

    @DisplayName("modulus returns z projection given vector has only z coordinate")
    @Test
    void modulusReturnsZProjection_GivenVectorHasOnlyZCoordinate() {

        // Given
        Vector vector = Vector.builder()
                .z(3.5)
                .build();

        // Then
        assertEquals(3.5, vector.modulus());
    }

    @DisplayName("modulus returns modulus given vector has all the three coordinates")
    @Test
    void modulusReturnsModulus_GivenVectorHasAllTheThreeCoordinates () {

        // Given
        Vector vector = Vector.builder()
                .x(2)
                .y(2)
                .z(1)
                .build();

        // Then
        assertEquals(3, vector.modulus());
    }

    @DisplayName("modulus returns 0 given the two vectors are orthogonal")
    @Test
    void dotProductReturnsZero_GivenOrthogonalVectors() {

        // Given
        Vector vector1 = Vector.builder()
                .x(2)
                .y(2)
                .build();
        Vector vector2 = Vector.builder()
                .z(3)
                .build();

        // Then
        assertEquals(0, vector1.dotProduct(vector2));
    }

    @DisplayName("modulus returns dot product given the two vectors")
    @Test
    void dotProductReturnsDotProduct_GivenVectors() {

        // Given
        Vector vector1 = Vector.builder()
                .x(2)
                .y(2)
                .z(3)
                .build();
        Vector vector2 = Vector.builder()
                .x(4)
                .y(4)
                .z(6)
                .build();

        // Then
        assertEquals(34, vector1.dotProduct(vector2));
    }

    @DisplayName("modulus returns null vector given the two vectors are parallel")
    @Test
    void crossProductReturnsNullVector_GivenVectorsAreParallel() {

        // Given
        Vector vector1 = Vector.builder()
                .x(2)
                .y(2)
                .z(3)
                .build();
        Vector vector2 = Vector.builder()
                .x(4)
                .y(4)
                .z(6)
                .build();

        // Then
        assertEquals(Vector.builder().build(), vector1.crossProduct(vector2));
    }

    @DisplayName("modulus returns orthogonal vector given the two vectors are orthogonal")
    @Test
    void crossProductReturnsOrthogonalVector_GivenVectorsAreOrthogonal() {

        // Given
        Vector vector1 = Vector.builder()
                .x(2)
                .build();
        Vector vector2 = Vector.builder()
                .z(2)
                .build();

        // Then
        assertEquals(Vector.builder().y(-4). build(), vector1.crossProduct(vector2));
    }
}
