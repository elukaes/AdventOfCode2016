package Day16.test;

import org.junit.jupiter.api.Test;

import static Day16.src.Main.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void replaceDigitsAndReverseTest() {
        assertEquals("10100011", replaceDigitsAndReverse("00111010"));
    }

    @Test
    void increaseLengthDataTo11() {
        assertEquals("10000011110", increaseLengthData("10000"));
    }

    @Test
    void increaseLengthDataTo23() {
        assertEquals("10000011110010000111110", increaseLengthData("10000011110"));
    }

    @Test
    void divideChecksumTo6Characters() {
        assertEquals("110101", divideChecksum("110010110100"));
    }

    @Test
    void divideChecksumTo3Characters() {
        assertEquals("100", divideChecksum("110101"));
    }

    @Test
    void findChecksumTest() {
        assertEquals("01100", findChecksum("10000011110010000111"));
    }
}