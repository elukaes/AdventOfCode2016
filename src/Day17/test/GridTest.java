package Day17.test;

import Day17.src.Grid;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    void shouldCreateGrid4x4() {
        char[][] expected = new char[4][];
        expected[0] = new char[]{'S', ' ', ' ', ' '};
        expected[1] = new char[]{' ', ' ', ' ', ' '};
        expected[2] = new char[]{' ', ' ', ' ', ' '};
        expected[3] = new char[]{' ', ' ', ' ', 'V'};
        Grid grid = new Grid(4);
        grid.createGrid();
        assertTrue(Arrays.deepEquals(expected, grid.getGrid()));
    }

}