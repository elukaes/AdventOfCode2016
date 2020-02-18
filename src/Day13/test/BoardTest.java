package Day13.test;

import Day13.src.BoardEnum;
import Day13.src.Board;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private final BoardEnum w = BoardEnum.wall;
    private final BoardEnum s = BoardEnum.open_space;
    @Test
    void createBoard10x7() {
        BoardEnum[][] expected = new BoardEnum[7][];
        expected[0] = new BoardEnum[]{s,w,s,w,w,w,w,s,w,w};
        expected[1] = new BoardEnum[]{s,s,w,s,s,w,s,s,s,w};
        expected[2] = new BoardEnum[]{w,s,s,s,s,w,w,s,s,s};
        expected[3] = new BoardEnum[]{w,w,w,s,w,s,w,w,w,s};
        expected[4] = new BoardEnum[]{s,w,w,s,s,w,s,s,w,s};
        expected[5] = new BoardEnum[]{s,s,w,w,s,s,s,s,w,s};
        expected[6] = new BoardEnum[]{w,s,s,s,w,w,s,w,w,w};
        Board board = new Board(10, 7, 10);
        assertTrue(Arrays.deepEquals(expected, board.getBoard()));
    }

}