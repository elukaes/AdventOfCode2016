package Day2.src;

public enum Direction {
    UP("U"),
    DOWN("D"),
    LEFT("L"),
    RIGHT("R");

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction.charAt(0);
    }
}
