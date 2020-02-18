package Day18.src;

public class Floor {
    private char[][] floor;

    public Floor(int height, int width, String input) {
        floor = new char[height][width];
        for(int i=0; i<floor[0].length; i++) {
            floor[0][i] = input.charAt(i);
        }
    }

    public void addNewRow(int row) {
        for(int i=0; i<floor[row].length; i++) {
            floor[row][i] = createNewTile(row-1, i);
        }
    }

    private char createNewTile(int row, int index) { //there is required checking only side tiles; middle tile can be in 2 states
        boolean[] isTrap = new boolean[]{false, false}; //0 - left, 1 - right
        if(index == 0) {
            isTrap[0] = false;
        }
        else if(floor[row][index-1] == Tile.TRAP.getTile()) {
            isTrap[0] = true;
        }
        if(index == floor[row].length-1) {
            isTrap[1] = false;
        }
        else if(floor[row][index+1] == Tile.TRAP.getTile()) {
            isTrap[1] = true;
        }

        if((isTrap[0] && !isTrap[1]) || (!isTrap[0] && isTrap[1])) {
            return Tile.TRAP.getTile();
        }
        return Tile.SAFE.getTile();
    }

    public int countSafeTile() {
        int counter = 0;
        for(int i=0; i<floor.length; i++) {
            for(int j=0; j<floor[i].length; j++) {
                if(floor[i][j] == Tile.SAFE.getTile()) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public char[][] getFloor() {
        return floor;
    }
}
