package Day1.src;

public enum Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static Direction turnLeft(Direction curr) {
        int size = Direction.values().length;
        return Direction.values()[(size+turn(curr)-1) % size];
    }

    public static Direction turnRight(Direction curr) {
        int size = Direction.values().length;
        return Direction.values()[(size+turn(curr)+1) % size];
    }

    public static int turn(Direction curr) {
        for(int i=0; i<Direction.values().length; i++) {
            if(Direction.values()[i] == curr) {
                return i;
            }
        }
        return 0;
    }
}
