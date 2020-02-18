package Day21.test;

import Day21.src.ScramblePassword;
import Day21.src.UnscramblePassword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnscramblePasswordTest {
    UnscramblePassword password;

    @BeforeEach
    void setUp() {
        password = new UnscramblePassword("decab");
    }

    @Test
    void scrambling() {
        password.rotatePassword('d');
        password.rotatePassword('b');
        password.movePosition(0, 3);
        password.movePosition(4, 1);
        password.rotatePassword(2, 1);
        password.reverseSubstring(0, 4);
        password.swapLetters('d', 'b');
        password.swapPosition(4, 0);
        assertEquals("abcde", password.toString());
    }
    /*
    @Test
    void swapPosition3WithPosition1() {
        password.swapPosition(3, 1);
        assertEquals("adcbe", password.toString());
    }

    @Test
    void swapLetterDWithLetterA() {
        password.swapLetters('d', 'a');
        assertEquals("dbcae", password.toString());
    }

    @Test
    void rotateLeft2Steps() {
        password.rotatePassword(1, 2);
        assertEquals("cdeab", password.toString());
    }

    @Test
    void rotateRight1Steps() {
        password.rotatePassword(2, 1);
        assertEquals("eabcd", password.toString());
    }

    @Test
    void rotateBasedOnPositionOfLetterD() {
        password.rotatePassword('d');
        assertEquals("cdeab", password.toString());
    }

    @Test
    void reversePositions0Through3() {
        password.reverseSubstring(0, 3);
        assertEquals("dcbae", password.toString());
    }

    @Test
    void movePosition2ToPosition4() {
        password.movePosition(2, 4);
        assertEquals("abdec", password.toString());
    }*/
}