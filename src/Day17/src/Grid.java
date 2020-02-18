package Day17.src;


public class Grid {
    private final int SIZE;
    private char[][] grid;
    private int posX;
    private int posY;

    public Grid(int size) {
        SIZE = size;
        posX = 0;
        posY = 0;
    }

    public boolean isFoundRoom() {
        if(posX == SIZE-1 && posY == SIZE-1) {
            return true;
        }
        return false;
    }

    public char parseHash(String hashMD5) {
        for(int i=0; i<SIZE; i++) {
            if (hashMD5.charAt(i) > 97 && hashMD5.charAt(i) < 103 && isPossibilityMove(i)) {
                if(i == 0) {
                    return 'U';
                }
                if(i == 1) {
                    return 'D';
                }
                if(i == 2) {
                    return 'L';
                }
                if(i == 3) {
                    return 'R';
                }
            }
        }
        return ' ';
    }

    private boolean isPossibilityMove(int direction) {
        if(direction == 0 && posY > 0) {
            return true;
        }
        if(direction == 1 && posY < SIZE-1) {
            return true;
        }
        if(direction == 2 && posX > 0) {
            return true;
        }
        if(direction == 3 && posX < SIZE-1) {
            return true;
        }
        return false;
    }

    public void position(String moves) {//'-' means left or up
        posX = 0; posY = 0;
        for(int i=0; i<moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U': {
                    posY--;
                    break;
                }
                case 'D': {
                    posY++;
                    break;
                }
                case 'L': {
                    posX--;
                    break;
                }
                case 'R': {
                    posX++;
                }
            }
        }
    }

    public char[][] getGrid() {
        return grid;
    }

    public void createGrid() {
        grid = new char[SIZE][SIZE];
        for(int i=0; i<SIZE; i++) {
            for(int j=0; j<SIZE; j++) {
                if(i == SIZE-1 && j == SIZE-1) {
                    grid[i][j] = 'V';
                    continue;
                }
                if(i == posY && j == posX) {
                    grid[i][j] = 'S';
                    continue;
                }
                grid[i][j] = ' ';
            }
        }
    }
}
