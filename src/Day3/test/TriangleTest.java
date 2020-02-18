package Day3.test;

import org.junit.jupiter.api.Test;

import static Day3.src.Triangle.isSameNumbersOfHundredDigits;
import static Day3.src.Triangle.isTrianglePossible;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
    @Test
    void triangleIsNotPossible() {
        assertFalse(isTrianglePossible(5, 10, 25));
    }

    @Test
    void triangleIsPossible() {
        assertTrue(isTrianglePossible(3, 4, 5));
    }

    @Test
    void notTheSameNumberOfHundredDigits() {
        assertFalse(isSameNumbersOfHundredDigits(120, 220, 120));
    }

    @Test
    void theSameNumberOfHundredDigits() {
        assertTrue(isSameNumbersOfHundredDigits(340, 350, 360));
    }
}