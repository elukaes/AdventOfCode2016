package Day1.src;

import java.util.LinkedList;
import java.util.List;

public class Movement {
    private Direction currDirection;
    private int positionX;
    private int positionY;
    private List<Integer> memoryPositionX;
    private List<Integer> memoryPositionY;
    private boolean firstVisitTwice;

    public Movement() { //set position[0, 0] and face to North
        currDirection = Direction.NORTH;
        positionX = 0;
        positionY = 0;
        memoryPositionX = new LinkedList<>();
        memoryPositionY = new LinkedList<>();
        firstVisitTwice = false;
    }

    public void move(char direction, int steps) {
        if(direction == 'L') {
            currDirection = Direction.turnLeft(currDirection);
        }
        else currDirection = Direction.turnRight(currDirection);
        for(int i=0; i<steps; i++) {
            if (currDirection.name().equals(Direction.NORTH.toString())) {
                positionY++;
            } else if (currDirection.name().equals(Direction.SOUTH.toString())) {
                positionY--;
            } else if (currDirection.name().equals(Direction.EAST.toString())) {
                positionX++;
            } else positionX--;

            if (!firstVisitTwice) {
                firstVisitTwice = firstPositionVisitTwice();
                memoryPositionX.add(positionX);
                memoryPositionY.add(positionY);
            }
        }
    }

    private boolean firstPositionVisitTwice() {
        int i = 0;
        while (memoryPositionX.size() > i) {
            if(memoryPositionX.get(i) == positionX && memoryPositionY.get(i) == positionY) {
                return true;
            }
            i++;
        }
        return false;
    }

    public String getCurrDirection() {
        return currDirection.toString();
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getFirstXVisitTwice() {
        return memoryPositionX.get(memoryPositionY.size()-1);
    }

    public int getFirstYVisitTwice() {
        return memoryPositionY.get(memoryPositionY.size()-1);
    }
}
