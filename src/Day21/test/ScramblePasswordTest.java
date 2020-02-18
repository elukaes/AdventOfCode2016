package Day21.test;

import Day21.src.ScramblePassword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScramblePasswordTest {
    ScramblePassword password;

    @BeforeEach
    void setUp() {
        password = new ScramblePassword("abcde");
    }

    @Test
    void swapPosition4WithPosition0() {
        password.swapPosition(4, 0);
        assertEquals("ebcda", password.toString());
    }

    @Test
    void swapLetterDWithLetterB() {
        password.swapLetters('d', 'b');
        assertEquals("adcbe", password.toString());
    }

    @Test
    void rotateLeft1Steps() {
        password.rotatePassword(1, 1);
        assertEquals("bcdea", password.toString());
    }

    @Test
    void rotateRight3Steps() {
        password.rotatePassword(2, 3);
        assertEquals("cdeab", password.toString());
    }

    @Test
    void rotateBasedOnPositionOfLetterE() {
        password.rotatePassword('e');
        assertEquals("eabcd", password.toString());
    }

    @Test
    void reversePositions1Through3() {
        password.reverseSubstring(1, 3);
        assertEquals("adcbe", password.toString());
    }

    @Test
    void movePosition4ToPosition2() {
        password.movePosition(4, 2);
        assertEquals("abecd", password.toString());
    }
}