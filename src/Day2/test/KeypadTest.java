package Day2.test;

import Day2.src.Keypad;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KeypadTest {
    Keypad keypad;

    @BeforeEach
    void setUp() {
        keypad = new Keypad(3, 1, 1);
    }
    @Test
    void isKeypadHasCorrectValues() {
        char[][] array = new char[3][];
        array[0] = new char[]{'1', '2', '3'};
        array[1] = new char[]{'4', '5', '6'};
        array[2] = new char[]{'7', '8', '9'};

        assertTrue(Arrays.deepEquals(array, keypad.getKeypad()));
    }

    @Test
    void digitEquals2() {
        keypad.move('U');
        assertEquals('2', keypad.getActDigit());
    }

    @Test
    void digitEquals4() {
        keypad.move('L');
        keypad.move('L');
        assertEquals('4', keypad.getActDigit());
    }

    @Test
    void digitEquals9() {
        keypad.move('R');
        keypad.move('R');
        keypad.move('D');
        assertEquals('9', keypad.getActDigit());
    }

}