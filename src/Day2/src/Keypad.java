package Day2.src;

public class Keypad {
    private char[][] keypad;
    private int actRow;
    private int actCol;

    public Keypad(int size, int beginRow, int beginCol) {
        keypad = new char[size][size];
        for(int i=1; i<=size; i++) {
            for(int j=1; j<=size; j++) {
                if(i==1) {
                    keypad[i - 1][j - 1] = (char) (i * j + 48); //int to ASCII
                }
                else keypad[i-1][j-1] = (char) (keypad[i-2][j-1] + size);
            }
        }
        actRow = beginRow;
        actCol = beginCol;
    }

    public Keypad() {
    }

    public void move(char direction) {
        if(direction == Direction.UP.getDirection() && actRow > 0) {
            actRow--;
        }
        else if(direction == Direction.DOWN.getDirection() && actRow < keypad.length-1) {
            actRow++;
        }
        else if(direction == Direction.LEFT.getDirection() && actCol > 0) {
            actCol--;
        }
        else if(direction == Direction.RIGHT.getDirection() && actCol < keypad.length-1) {
            actCol++;
        }
    }

    public char getActDigit() {
        return keypad[actRow][actCol]; //ASCII to int
    }

    public char[][] getKeypad() {
        return keypad;
    }
}
