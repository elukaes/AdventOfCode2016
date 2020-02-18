package Day8.test;

import Day8.src.LittleScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static Day8.src.Main.parseFile;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    LittleScreen screen;

    @BeforeEach
    void setUp() {
        screen = new LittleScreen(6, 50);
    }

    @Test
    void createRectangle3x2() {
        char[][] expected = new char[6][50];
        for(int i=0; i<6; i++) {
            for(int j=0; j<50; j++) {
                if(i<2 && j<3) {
                    expected[i][j] = '#';
                }
                else expected[i][j] = '.';
            }
        }
        parseFile("rect 3x2", screen);
        assertTrue(Arrays.deepEquals(expected, screen.getScreen()));
    }

    @Test
    void rotateRow0By4() {
        char[][] expected = new char[6][50];
        for(int i=0; i<6; i++) {
            for(int j=0; j<50; j++) {
                 expected[i][j] = '.';
            }
        }
        expected[0][4] = '#'; expected[0][5] = '#'; expected[0][6] = '#';
        expected[1][0] = '#'; expected[1][1] = '#'; expected[1][2] = '#';
        screen.createRectangle(3, 2);
        parseFile("rotate row y=0 by 4", screen);
        assertTrue(Arrays.deepEquals(expected, screen.getScreen()));
    }

    @Test
    void rotateColumn1By1() {
        char[][] expected = new char[6][50];
        for(int i=0; i<6; i++) {
            for(int j=0; j<50; j++) {
                expected[i][j] = '.';
            }
        }
        expected[0][0] = '#'; expected[0][2] = '#'; expected[1][0] = '#';
        expected[1][1] = '#'; expected[1][2] = '#'; expected[2][1] = '#';
        screen.createRectangle(3, 2);
        parseFile("rotate column x=1 by 1", screen);
        assertTrue(Arrays.deepEquals(expected, screen.getScreen()));
    }
}