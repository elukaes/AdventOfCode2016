package Day13.src;

public class Board {
    private final int DESIGNER_NUMBER;
    private BoardEnum[][] board;

    public Board(int width, int height, int number) {
        DESIGNER_NUMBER = number;
        board = new BoardEnum[height][width];
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(createPlace(j, i)) {
                    board[i][j] = BoardEnum.open_space;
                }
                else board[i][j] = BoardEnum.wall;
            }
        }
    }

    private boolean createPlace(int x, int y) {
        String binRep = Integer.toBinaryString((x*x + 3*x + 2*x*y + y + y*y) + DESIGNER_NUMBER);
        int sumOf1 = count1InBinNb(binRep);
        if(sumOf1%2 == 0) {
            return true;
        }
        return false;
    }

    private int count1InBinNb(String binRep) {
        int counter = 0;
        for(int i=0; i<binRep.length(); i++) {
            if(binRep.charAt(i) == '1') {
                counter++;
            }
        }
        return counter;
    }

    public boolean isOpenSpace(int x, int y) {
        if(board[x][y] == BoardEnum.open_space) {
            return true;
        }
        return false;
    }

    public BoardEnum[][] getBoard() {
        return board;
    }
}