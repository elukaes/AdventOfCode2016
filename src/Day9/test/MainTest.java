package Day9.test;

import static org.junit.jupiter.api.Assertions.*;
import static Day9.src.Main.*;
import org.junit.jupiter.api.Test;

class MainTest {
    @Test
    void decompressedTextEqualsADVENT() {
        assertEquals("ADVENT", parseTextTask1("ADVENT"));
    }

    @Test
    void decompressedTextEqualsABBBBBC() {
        assertEquals("ABBBBBC", parseTextTask1("A(1x5)BC"));
    }

    @Test
    void decompressedTextEqualsXYZXYZXYZ() {
        assertEquals("XYZXYZXYZ", parseTextTask1("(3x3)XYZ"));
    }

    @Test
    void decompressedTextEqualsABCBCDEFEFG() {
        assertEquals("ABCBCDEFEFG", parseTextTask1("A(2x2)BCD(2x2)EFG"));
    }

    @Test
    void decompressedTextEquals1x3AWithParentheses() {
        assertEquals("(1x3)A", parseTextTask1("(6x1)(1x3)A"));
    }

    @Test
    void decompressedTextEqualsX3x3ABC3x3ABCYWithParentheses() {
        assertEquals("X(3x3)ABC(3x3)ABCY", parseTextTask1("X(8x2)(3x3)ABCY"));
    }
}