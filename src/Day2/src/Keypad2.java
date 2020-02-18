package Day2.src;

import org.w3c.dom.ls.LSOutput;

public class Keypad2 extends Keypad {
    private char[][] keypad;
    private int actRow;
    private int actCol;

    public Keypad2(int size, int beginRow, int beginCol) {
        keypad = new char[size][size];

        int number = 49;
        for (int i = 0; i < size; i++) {
            for (int j = firstElementInRow(i); j < lastElementInRow(i); j++) {
                if(number < 58) { //digits
                    keypad[i][j] = (char) number;
                }
                if(number == 58) { //jump to letters
                    number = 65;
                }
                if(number > 64) { //letters
                    keypad[i][j] = (char) number;
                }
                number++;
            }
        }
        actRow = beginRow;
        actCol = beginCol;
    }

    @Override
    public void move(char direction) {
        if(direction == Direction.UP.getDirection() && actRow > countBorderBegin('C')) {
            actRow--;
        }
        else if(direction == Direction.DOWN.getDirection() && actRow < countBorderEnd('C')) {
            actRow++;
        }
        else if(direction == Direction.LEFT.getDirection() && actCol > countBorderBegin('R')) {
            actCol--;
        }
        else if(direction == Direction.RIGHT.getDirection() && actCol < countBorderEnd('R')) {
            actCol++;
        }
    }

    private int countBorderBegin(char dir) {
        int border = Math.abs(keypad.length/2 - ((dir == 'R') ? actRow : actCol));
        if(border == keypad.length/2) {
            return keypad.length;
        }
        return border;
    }

    private int countBorderEnd(char dir) {
        if(((dir == 'R') ? actRow : actCol) == keypad.length/2) {
            return keypad.length - 1;
        }
        return (keypad.length - 1) - Math.abs(keypad.length/2 - ((dir == 'R') ? actRow : actCol));
    }

    //row begin from 0 to keypad.length-1
    //last element in row from 1 to keypad.length
    private int lastElementInRow(int row) {
        return firstElementInRow(row) + keypad.length - (2 * (Math.abs(row - (keypad.length/2))));
    }

    //row and return element begin from 0 to keypad.length-1
    private int firstElementInRow(int row) {
        return Math.abs((keypad.length/2) - row);
    }

    @Override
    public char getActDigit() {
        return keypad[actRow][actCol]; //ASCII to int
    }

    @Override
    public char[][] getKeypad() {
        return keypad;
    }
}
