package Day18.src;

public enum Tile {
    SAFE('.'),
    TRAP('^');

    private char tile;

    Tile(char tile) { this.tile = tile; }

    public char getTile() {
        return tile;
    }
}
