package Day2.test;

import Day2.src.Keypad2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Keypad2Test {
    Keypad2 keypad2;
    @BeforeEach
    void setUp() { keypad2 = new Keypad2(5, 2, 0); }
    @Test
    void isKeypadHasCorrectValues() {
        char[][] array = new char[5][5];
        array[0][2]='1'; array[1][1]='2'; array[1][2]='3'; array[1][3]='4';
        array[2][0]='5'; array[2][1]='6'; array[2][2]='7'; array[2][3]='8'; array[2][4]='9';
        array[3][1]='A'; array[3][2]='B'; array[3][3]='C'; array[4][2]='D';

        assertTrue(Arrays.deepEquals(array, keypad2.getKeypad()));
    }
    @Test
    void digitEquals5() {
        System.out.println(keypad2.getActDigit());
        keypad2.move('U');
        assertEquals('5', keypad2.getActDigit());
    }

    @Test
    void digitEquals6() {
        keypad2.move('R');
        assertEquals('6', keypad2.getActDigit());
    }

    @Test
    void digitEquals2() {
        keypad2.move('R');
        keypad2.move('U');
        assertEquals('2', keypad2.getActDigit());
    }

    @Test
    void digitEquals11() {
        keypad2.move('R');
        keypad2.move('R');
        keypad2.move('D');
        assertEquals('B', keypad2.getActDigit());
    }
}