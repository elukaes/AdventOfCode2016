package Day8.test;

import static org.junit.jupiter.api.Assertions.*;

import Day8.src.LittleScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class LittleScreenTest {
    LittleScreen screen;

    @BeforeEach
    void setUp() {
        screen = new LittleScreen(6, 50);
    }

    @Test
    void isScreenCreateCorrectly() {
        char[][] expected = new char[6][50];
        for(int i=0; i<6; i++) {
            for(int j=0; j<50; j++) {
                expected[i][j] = '.';
            }
        }
        assertTrue(Arrays.deepEquals(expected, screen.getScreen()));
    }

    @Test
    void shouldCreateRectangle3x2() {
        char[][] expected = new char[6][50];
        for(int i=0; i<6; i++) {
            for(int j=0; j<50; j++) {
                if(i<2 && j<3) {
                    expected[i][j] = '#';
                }
                else expected[i][j] = '.';
            }
        }
        screen.createRectangle(3, 2);
        assertTrue(Arrays.deepEquals(expected, screen.getScreen()));
    }

    @Test
    void shouldCreateRectangle6x20() {
        char[][] expected = new char[6][50];
        for(int i=0; i<6; i++) {
            for(int j=0; j<50; j++) {
                if(i<6 && j<20) {
                    expected[i][j] = '#';
                }
                else expected[i][j] = '.';
            }
        }
        screen.createRectangle(20, 6);
        assertTrue(Arrays.deepEquals(expected, screen.getScreen()));
    }

    @Test
    void shouldAppearExceptionIndexOutOfBounds() {
        IndexOutOfBoundsException exception = assertThrows(IndexOutOfBoundsException.class,
                () -> screen.createRectangle(51, 3));
        assertEquals("Index "+screen.getColumns()+" out of bounds for length "+screen.getColumns(), exception.getMessage());
    }

    @Test
    void shiftRow0By5() {
        char[][] expected = new char[6][50];
        for(int i=0; i<6; i++) {
            for(int j=0; j<50; j++) {
                expected[i][j] = '.';
            }
        }
        expected[0][5] = '#'; expected[0][6] = '#';
        screen.createRectangle(2, 1);
        screen.rotateRow(0, 5);
        assertTrue(Arrays.deepEquals(expected, screen.getScreen()));
    }

    @Test
    void shiftColumn0By3() {
        char[][] expected = new char[6][50];
        for(int i=0; i<6; i++) {
            for(int j=0; j<50; j++) {
                expected[i][j] = '.';
            }
        }
        expected[3][0] = '#'; expected[0][1] = '#';
        screen.createRectangle(2, 1);
        screen.rotateColumn(0, 3);
        assertTrue(Arrays.deepEquals(expected, screen.getScreen()));
    }

    @Test
    void litPixelsEqual15() {
        screen.createRectangle(3, 5);
        assertEquals(15, screen.countLitPixels());
    }
}