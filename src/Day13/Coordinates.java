package Day13;

public class Coordinates {
    private int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        Coordinates coordinates = (Coordinates) obj;
        return x == coordinates.x && y == coordinates.y;
    }
}
