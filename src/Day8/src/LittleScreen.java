package Day8.src;

public class LittleScreen {
    private char[][] screen;

    public LittleScreen(int row, int column) {
        screen = new char[row][column];
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                screen[i][j] = '.';
            }
        }
    }

    public void createRectangle(int column, int row) {
        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                screen[i][j] = '#';
            }
        }
    }

    public void rotateRow(int row, int shift) {
        char[] tmpArray = new char[screen[0].length];
        for(int i=0; i<screen[row].length; i++) {
            tmpArray[(shift+i) % screen[row].length] = screen[row][i];
        }
        screen[row] = tmpArray;
    }

    public void rotateColumn(int column, int shift) {
        char[] tmpArray = new char[screen.length];
        for(int i=0; i<screen.length; i++) {
            tmpArray[(shift+i) % screen.length] = screen[i][column];
        }
        for(int i=0; i<screen.length; i++) {
            screen[i][column] = tmpArray[i];
        }
    }

    public int countLitPixels() {
        int counter = 0;
        for(int i=0; i<screen.length; i++) {
            for(int j=0; j<screen[i].length; j++) {
                if(screen[i][j] == '#') {
                    counter++;
                }
            }
        }
        return counter;
    }

    public char getValueOfCell(int row, int column) {
        return screen[row][column];
    }

    public int getRows() {
        return screen.length;
    }

    public int getColumns() {
        return screen[0].length;
    }

    public char[][] getScreen() {
        return screen;
    }
}
