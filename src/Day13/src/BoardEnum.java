package Day13.src;

public enum BoardEnum {
    wall('#'),
    open_space('.');

    private char place;

    BoardEnum(char place) {
        this.place = place;
    }

    public char getPlace() {
        return place;
    }
}
