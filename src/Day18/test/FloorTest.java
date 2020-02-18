package Day18.test;

import Day18.src.Floor;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {
    @Test
    void checkTiles5x3() {
        char[][] expected = new char[3][];
        expected[0] = new char[]{'.','.','^','^','.'};
        expected[1] = new char[]{'.','^','^','^','^'};
        expected[2] = new char[]{'^','^','.','.','^'};
        Floor floor = new Floor(3, 5, "..^^.");
        floor.addNewRow(1);
        floor.addNewRow(2);
        Arrays.deepEquals(expected, floor.getFloor());
    }

    @Test
    void amountOfSafeTilesEquals38() {
        Floor floor = new Floor(10, 10, ".^^.^.^^^^");
        for(int i=1; i<10; i++) {
            floor.addNewRow(i);
        }
        assertEquals(38, floor.countSafeTile());
    }
}